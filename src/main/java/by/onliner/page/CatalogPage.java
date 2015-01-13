package by.onliner.page;

import by.onliner.constant.CatalogPageConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends AbstractPage{

    @FindBy(xpath = CatalogPageConstants.NOTEBOOKS_LINK_XPATH)
    private WebElement notebookLink;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public NotebooksPage goToNotebooks(){
        notebookLink.click();
        return new NotebooksPage(driver);
    }

}
