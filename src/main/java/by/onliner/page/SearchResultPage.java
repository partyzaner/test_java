package by.onliner.page;

import by.onliner.constant.SearchResultPageConstants;
import by.onliner.model.Notebook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import java.util.List;

public class SearchResultPage extends AbstractPage{

    @FindBy(xpath = SearchResultPageConstants.FIRST_ELEMENT_PRICES_XPATH)
    private List<WebElement> firstElementPrices;

    @FindBy(xpath = SearchResultPageConstants.SORT_BY_PRICE_XPATH)
    private Link sortByPrice;

    @FindBy(xpath = SearchResultPageConstants.GRID_VIEW_XPATH)
    private Link gridView;

    @FindBy(xpath = SearchResultPageConstants.NOTE_NAMES_XPATH)
    private List<WebElement> noteNameList;

    @FindBy(xpath = SearchResultPageConstants.NOTE_PRICE_LIST_XPATH)
    private List<WebElement> notePriceList;

    @FindBy(xpath = SearchResultPageConstants.LAST_PAGE_LINK_XPATH)
    private Link lastPageLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Notebook getFirstNote(){
        Notebook note = new Notebook(noteNameList.get(0).getText(), notePriceList.get(0).getText());
        return note;
    }

    public Notebook getLastNote(){
        lastPageLink.click();
        String name = noteNameList.get(noteNameList.size()-1).getText();
        String prices = notePriceList.get(notePriceList.size()-1).getText();
        Notebook notebook = new Notebook(name, prices);
        return notebook;
    }

    public void sortByPriceClick(){
        sortByPrice.click();
    }

    public int getCount(){
        List<WebElement> firstPageLinks = driver.findElements(By.xpath(SearchResultPageConstants.FIRST_PAGE_LINK_XPATH));
        if (firstPageLinks.size() != 0){
            firstPageLinks.get(0).click();
        }
        int fullNoteCount = (Integer.parseInt(lastPageLink.getText()) - 1) * 15;
        lastPageLink.click();
        int count = noteNameList.size() + fullNoteCount;
        driver.navigate().back();
        return count;
    }
}
