package by.onliner.test;

import by.onliner.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonActions {

    protected static final WebDriver driver = DriverManager.getInstance().getDriver();

    @BeforeSuite
    public void startDriver(){
        DriverManager.getInstance().initDriver();
    }

    @AfterSuite
    public void closeDriver(){
        DriverManager.getInstance().closeDriver();
    }
}