package by.onliner.test;

import by.onliner.constant.ProjectConstants;
import by.onliner.model.Notebook;
import by.onliner.page.CatalogPage;
import by.onliner.page.HomePage;
import by.onliner.page.NotebooksPage;
import by.onliner.page.SearchResultPage;
import by.onliner.model.SearchModel;
import by.onliner.utils.JsonParser;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class NotebookSearch extends CommonActions{

    private static final Logger LOGGER = Logger.getLogger(NotebookSearch.class);

    @Test
    public void notebookSearch(){
        SearchModel searchModel;
        searchModel = JsonParser.deserializeJson(new File(ProjectConstants.DEFAULT_JSON_LOCATION));
        HomePage homePage = new HomePage(driver);
        homePage.openCatalogLink();
        CatalogPage catalogPage = new CatalogPage(driver);
        NotebooksPage notebooksPage = catalogPage.goToNotebooks();
        SearchResultPage searchResultPage = notebooksPage.find_notebooks(searchModel);
        searchResultPage.sortByPriceClick();
        int resultCount = searchResultPage.getCount();
        Notebook firstNote = searchResultPage.getFirstNote();
        searchResultPage.sortByPriceClick();
        Notebook lastNote = searchResultPage.getLastNote();
        int resultCountAfter = searchResultPage.getCount();
        LOGGER.info("First Count = " + resultCount + " Second result count = " + resultCountAfter);
        LOGGER.info("First notebook = " + firstNote + " Last notebook = " + lastNote);
        Assert.assertEquals(resultCount, resultCountAfter);
        Assert.assertEquals(firstNote, lastNote);
    }
}
