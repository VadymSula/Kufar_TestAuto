package pages.android.advertisements;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;

public class Advertisements extends AndroidBasePage {
    @AndroidFindBy(id = "se.scmv.belarus:id/menu_listing")
    private WebElement ADS;
    @AndroidFindBy(id = "se.scmv.belarus:id/filtersButton")
    private WebElement FILTERS_BUTTON;
    @AndroidFindBy(id = "se.scmv.belarus:id/searchFiltersButton")
    private WebElement MENU_FILTERS;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.CheckBox")
    private WebElement LIKE_OF_FIRST_ELEMENT;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup")
    private WebElement FIRST_ELEMENT_OF_ADS;

    public Advertisements(AndroidDriver driver) {
        super(driver);
    }

    @Step("Go to advertisements list")
    public void goToAdvertisements() {
        buttons.searchAndClickButtonBy(MENU_LISTING);
    }

    @Step("Go to first advert from list")
    public void goToFirstAdvert() {
        buttons.searchAndClickButtonBy(FIRST_ELEMENT_OF_ADS);
    }

    @Step("Go to favorites")
    public void goToFavorites() {
        buttons.searchAndClickButtonBy(MENU_FAVORITES);
    }

    @Step("Go to filters menu")
    public void goToFiltersMenu() {
        buttons.searchAndClickButtonBy(MENU_FILTERS);
    }
}
