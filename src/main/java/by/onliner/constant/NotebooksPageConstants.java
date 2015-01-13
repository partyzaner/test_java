package by.onliner.constant;

public interface NotebooksPageConstants {
    public static final String MANUFACTURER_SELECT_XPATH  = "//select[contains(@id,'lmfr')]";
    public static final String BYR_BUTTON_XPATH = "//ul[@class='catalog-bar__switcher-list']/li[@data-currency='BYR']";
    public static final String USD_BUTTON_XPATH = "//ul[@class='catalog-bar__switcher-list']/li[@data-currency='USD']";
    public static final String ADD_MANUFACTURER_XPATH = "//tr[@id='more_mfrs']//a";
    public static final String MIN_PRICE_INPUT_XPATH = "//input[@name='sp[price][from]']";
    public static final String MAX_PRICE_INPUT_XPATH = "//input[@name='sp[price][to]']";
    public static final String MIN_SCREEN_SELECT_XPATH = "//select[@name='sp[diagonalnb][from]']";
    public static final String MAX_SCREEN_SELECT_XPATH = "//select[@name='sp[diagonalnb][to]']";
    public static final String SEARCH_BUTTON_XPATH = "//input[@name='search']";

}
