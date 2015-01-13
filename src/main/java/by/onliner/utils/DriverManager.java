package by.onliner.utils;

import by.onliner.Runner;
import by.onliner.constant.ProjectConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static DriverManager instance;

    private WebDriver driver;

    private DriverManager(){}

    public static DriverManager getInstance(){
        if (instance == null){
            synchronized (DriverManager.class){
                if (instance == null){
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public void initDriver(){
        if(driver == null){
            String browser = Runner.getArguments().getBrowser();
            if("firefox".equals(browser)){
                driver = new FirefoxDriver();}
            else if ("chrome".equals(browser)) {
                driver = new ChromeDriver();}
            else driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(ProjectConstants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
            initDriver();
        }
        return driver;
    }

    public void closeDriver(){
        driver.close();
    }
}
