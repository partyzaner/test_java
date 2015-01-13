package by.onliner.page;

import by.onliner.constant.ProjectConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    public void waitForElement(By by){
        (new WebDriverWait(driver, ProjectConstants.DEFAULT_TIMEOUT)).until
                (ExpectedConditions.presenceOfElementLocated(by));
    }
}
