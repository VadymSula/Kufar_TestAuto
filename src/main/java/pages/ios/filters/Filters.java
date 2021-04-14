package pages.ios.filters;

import enums.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.IOSBasePage;

public class Filters extends IOSBasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"navbar central\"`]/XCUIElementTypeButton[3]")
    private WebElement FILTER_BUTTON;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"search_table_view\"`]/XCUIElementTypeCell[4]")
    private WebElement CATEGORIES;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Недвижимость\"]/..")
    private WebElement IMMOVABILITY_SECTION;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Квартиры\"]/..")
    private WebElement APARTMENT_SECTION;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"search_table_view\"`]/XCUIElementTypeCell[6]/XCUIElementTypeTextField[2]")
    private WebElement PRICE_FROM;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"search_table_view\"`]/XCUIElementTypeCell[6]/XCUIElementTypeTextField[1]")
    private WebElement PRICE_TO;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTable[`name == \"search_table_view\"`]/XCUIElementTypeCell[9]/XCUIElementTypeOther[1]")
    private WebElement COUNT_OF_ROOMS_SECTION;
    @iOSXCUITFindBy(accessibility = "1")
    private WebElement COUNT_OF_ROOMS_TEXT;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"1\"]/..")
    private WebElement FIRST_VARIANT_COUNT_OF_ROOMS;
    @iOSXCUITFindBy(accessibility = "Готово")
    private WebElement READY_BUTTON;
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Показать')]/..")
    private WebElement VIEW_RESULTS_BUTTON;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Kufar.REMapView\"`]/XCUIElementTypeButton[1]")
    private WebElement GO_TO_LIST_VIEW_BUTTON;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private WebElement FIRST_ELEMENT_OF_ADVERTS;

// TODO Добавить getText() для сравнений

    public Filters(AppiumDriver driver) {
        super(driver);
    }

    public void goToFilters() {
        buttons.searchAndClickButtonBy(FILTER_BUTTON);
    }

    public void chooseApartmentCategory() {
        buttons.searchAndClickButtonBy(CATEGORIES);
        buttons.searchAndClickButtonBy(IMMOVABILITY_SECTION);
        buttons.searchAndClickButtonBy(APARTMENT_SECTION);
    }

    public void inputPrice(String priceFrom, String priceTo) {
        elements.searchFieldAndSendKey(PRICE_FROM, priceFrom);
        elements.searchFieldAndSendKey(PRICE_TO, priceTo);
    }

    public void chooseCountOfRooms() {
        screen.swipe(Direction.UP);
        buttons.searchAndClickButtonBy(COUNT_OF_ROOMS_SECTION);
        buttons.searchAndClickButtonBy(FIRST_VARIANT_COUNT_OF_ROOMS);
        buttons.searchAndClickButtonBy(READY_BUTTON);
    }

    public String getCountOfRooms() {
        return elements.getTextFromElement(COUNT_OF_ROOMS_TEXT);
    }

    public void goToFirstAdvert() {
        buttons.searchAndClickButtonBy(FIRST_ELEMENT_OF_ADVERTS);
    }

    public void getViewResults() {
        buttons.searchAndClickButtonBy(VIEW_RESULTS_BUTTON);
    }

    public void goToListView() {
        buttons.searchAndClickButtonBy(GO_TO_LIST_VIEW_BUTTON);
    }
}
