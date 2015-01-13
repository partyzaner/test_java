package by.onliner.page;
import by.onliner.constant.HomePageConstants;
import by.onliner.constant.ProjectConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(ProjectConstants.URL);
    }

    @FindBy(xpath = HomePageConstants.CATALOG_LINK_XPATH)
    private WebElement catalogLink;

    public void openCatalogLink(){
        catalogLink.click();
    }
}
