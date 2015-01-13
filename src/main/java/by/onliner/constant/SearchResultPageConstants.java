package by.onliner.constant;

public interface SearchResultPageConstants {
    public static final String FIRST_ELEMENT_PRICES_XPATH = "//tr[4]//td[@class='pprice']";
    public static final String SORT_BY_PRICE_XPATH = "//a[contains(@href, 'sort_by=price')]";
    public static final String GRID_VIEW_XPATH = "//a[contains(@href, 'gridview')]";
    public static final String NOTE_NAMES_XPATH = "//strong[@class='pname']/a";
    public static final String NOTE_PRICE_LIST_XPATH = "//div[@class='pprice']";
    public static final String LAST_PAGE_LINK_XPATH = "//td[not(@align='right')]/strong/a[contains(@href, 'page=')][last()]";
    public static final String FIRST_PAGE_LINK_XPATH = "//a[text()='1']";
}
