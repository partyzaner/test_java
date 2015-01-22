package by.onliner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BrowserTest {

    @Test
    public void browserTest() throws IOException{
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://onliner.by");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("fire-screenshot.png"));
    }

    @Test
    public void browserChromeTest() throws IOException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tut.by");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("chrome-screenshot.png"));
    }

    @Test
    public void htmlUnitTest() throws IOException {
        WebDriver driver = new HtmlUnitDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("html-screenshot.png"));
    }

    @Test
    public void phantomJSTest() throws IOException {
        WebDriver driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("phantom-screenshot.png"));
    }
}
