package by.onliner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class BrowserTest {

    @Test
    public void browserTest() throws IOException{
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("fire-screenshot.png"));
    }

    @Test
    public void browserChromeTest() throws IOException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://tut.by");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("chrome-screenshot.png"));
    }
}
