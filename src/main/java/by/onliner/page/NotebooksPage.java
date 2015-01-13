package by.onliner.page;

import by.onliner.constant.NotebooksPageConstants;
import by.onliner.model.SearchModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;

import java.util.Iterator;
import java.util.List;

public class NotebooksPage extends AbstractPage {

    @FindBy(xpath = NotebooksPageConstants.BYR_BUTTON_XPATH)
    private WebElement byrCurrencyButton;

    @FindBy(xpath = NotebooksPageConstants.USD_BUTTON_XPATH)
    private WebElement usdCurrencyButton;

    @FindBy(xpath = NotebooksPageConstants.MANUFACTURER_SELECT_XPATH)
    private List<Select> manufacturerSelects;

    @FindBy(xpath = NotebooksPageConstants.ADD_MANUFACTURER_XPATH)
    private Link addManufacturerLink;

    @FindBy(xpath = NotebooksPageConstants.MIN_PRICE_INPUT_XPATH)
    private WebElement minPriceInput;

    @FindBy(xpath = NotebooksPageConstants.MAX_PRICE_INPUT_XPATH)
    private WebElement maxPriceInput;

    @FindBy(xpath = NotebooksPageConstants.MIN_SCREEN_SELECT_XPATH)
    private Select minScreenSelect;

    @FindBy(xpath = NotebooksPageConstants.MAX_SCREEN_SELECT_XPATH)
    private Select maxScreenSelect;

    @FindBy(xpath = NotebooksPageConstants.SEARCH_BUTTON_XPATH)
    private Button searchButton;

    public NotebooksPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage find_notebooks(SearchModel searchModel){
        setCurrencyUSD(true);
        selectManufacturers(searchModel.getManufacturers());
        setPrices(searchModel.getMinPrice(), searchModel.getMaxPrice());
        setScreenSizes(searchModel.getMinScreen(), searchModel.getMaxScreen());
        searchButton.click();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return searchResultPage;
    }

    private void selectManufacturers(List<String> brands){
        Iterator<String> iterator = brands.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            if (counter != 0){
                addManufacturerLink.click();
            }
            manufacturerSelects.get(counter).selectByValue(iterator.next().toLowerCase());
            counter++;
        }
    }

    private void setPrices(String minPrice, String maxPrice){
        minPriceInput.sendKeys(minPrice);
        maxPriceInput.sendKeys(maxPrice);
    }

    private void setScreenSizes(String minScreen, String maxScreen){
        minScreenSelect.selectByValue(minScreen);
        maxScreenSelect.selectByValue(maxScreen);
    }


    public void setCurrencyUSD(boolean isUSD){
        if (isUSD){
            usdCurrencyButton.click();
        } else{
            byrCurrencyButton.click();
        }
    }
}
