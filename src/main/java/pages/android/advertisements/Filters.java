package pages.android.advertisements;

import enums.Direction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;

public class Filters extends AndroidBasePage {
    @AndroidFindBy(id = "se.scmv.belarus:id/search")
    private WebElement SEARCH_FIELD;
    @AndroidFindBy(id = "se.scmv.belarus:id/searchFiltersButton")
    private WebElement FILTERS_BUTTON;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    private WebElement CATEGORIES_LIST;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Недвижимость')]/..")
    private WebElement IMMOVABILITY_CATEGORY;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Квартиры')]/..")
    private WebElement APARTMENT_SECTION;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Квартиры')]")
    private WebElement TYPE_OF_SECTION;
    @AndroidFindBy(id = "se.scmv.belarus:id/filter_menu_apply")
    private WebElement FILTER_MENU_APPLY_BUTTON;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
    private WebElement PRICE_FIELD;
    @AndroidFindBy(id = "se.scmv.belarus:id/inputFrom")
    private WebElement PRICE_FROM;
    @AndroidFindBy(id = "se.scmv.belarus:id/inputTo")
    private WebElement PRICE_TO;
    @AndroidFindBy(id = "se.scmv.belarus:id/apply")
    private WebElement APPLY_BUTTON;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[5]")
    private WebElement COUNT_OF_ROOMS_SELECT;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    private WebElement FIRST_VARIANT_OF_COUNT_ROOMS;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement COUNT_OF_ROOMS_TEXT;
    @AndroidFindBy(id = "se.scmv.belarus:id/showAdverts")
    private WebElement SHOW_ADVERTS_BUTTON;
    @AndroidFindBy(id = "se.scmv.belarus:id/listingButton")
    private WebElement LISTING_VIEW_BUTTON;
    @AndroidFindBy(id = "se.scmv.belarus:id/button")
    private WebElement SAVE_SEARCH_BUTTON;
    @AndroidFindBy(id = "se.scmv.belarus:id/close")
    private WebElement CLOSE_BUTTON;

    public Filters(AndroidDriver driver) {
        super(driver);
    }

    @Step("Go to advertisements list")
    public void goToAdvertisements() {
        buttons.searchAndClickButtonBy(MENU_LISTING);
    }

    @Step("Go to filters menu")
    public void goToFiltersMenu() {
        buttons.searchAndClickButtonBy(FILTERS_BUTTON);
    }

    @Step("Go to menu profile")
    public void goToMenuProfile() {
        buttons.searchAndClickButtonBy(MENU_PROFILE);
    }

    @Step("Close filters")
    public void closeFilters() {
        buttons.searchAndClickButtonBy(CLOSE_BUTTON);
    }

    @Step("Save search to favorite")
    public void saveSearch() {
        screen.scrollablePage("Cохранить поиск");
        screen.swipe(Direction.UP);
        buttons.searchAndClickButtonBy(SAVE_SEARCH_BUTTON);
    }

    @Step("Choose immovability category")
    public void chooseImmovabilityCategory() {
        buttons.searchAndClickButtonBy(CATEGORIES_LIST);
        buttons.searchAndClickButtonBy(IMMOVABILITY_CATEGORY);
    }

    @Step("Get type of section")
    public String getTypeOfSection() {
        return elements.getTextFromElement(TYPE_OF_SECTION);
    }

    @Step("Input price in style \"From\" - \"To\"")
    public void inputPriceFromTo(String priceFrom, String priceTo) {
        buttons.searchAndClickButtonBy(PRICE_FIELD);
        elements.searchFieldAndSendKey(PRICE_FROM, priceFrom);
        elements.searchFieldAndSendKey(PRICE_TO, priceTo);
        clickOnApply();
    }

    @Step("Choose apartment section")
    public void chooseApartmentSection() {
        buttons.searchAndClickButtonBy(APARTMENT_SECTION);
    }

    @Step("Choose count rooms of apartment")
    public void chooseCountOfRooms() {
        buttons.searchAndClickButtonBy(COUNT_OF_ROOMS_SELECT);
        buttons.searchAndClickButtonBy(FIRST_VARIANT_OF_COUNT_ROOMS);
    }

    @Step("Get count rooms of apartments")
    public String getCountOfRooms() {
        return elements.getTextFromElement(COUNT_OF_ROOMS_TEXT);
    }

    @Step("Click on apply button")
    public void clickOnApply() {
        buttons.searchAndClickButtonBy(APPLY_BUTTON);
    }

    @Step("Show adverts after filters application")
    public void showAdvertsAfterFilters() {
        buttons.searchAndClickButtonBy(SHOW_ADVERTS_BUTTON);
    }

    @Step("Go to results after filters application")
    public void goToListingViewResults() {
        buttons.searchAndClickButtonBy(LISTING_VIEW_BUTTON);
    }
}
