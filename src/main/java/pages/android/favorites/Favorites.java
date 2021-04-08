package pages.android.favorites;

import enums.Direction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;

public class Favorites extends AndroidBasePage {
    @AndroidFindBy(id = "se.scmv.belarus:id/menu_favorites")
    private WebElement MENU_FAVORITES;
    @AndroidFindBy(id = "se.scmv.belarus:id/login")
    private WebElement SIGN_IN_OR_LOGIN;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Объявления\"]/android.widget.LinearLayout")
    private WebElement ADVERTISEMENT;
    @AndroidFindBy(accessibility = "Поиски")
    private WebElement SEARCH_FAVORITES;
    @AndroidFindBy(accessibility = "Продавцы")
    private WebElement SELLERS;
    @AndroidFindBy(id = "se.scmv.belarus:id/subject")
    private WebElement TITLE_FAVORITE_SEARCH;
    @AndroidFindBy(id = "se.scmv.belarus:id/favoriteContainer")
    private WebElement IS_FAVORITE;
    @AndroidFindBy(id = "se.scmv.belarus:id/name")
    private WebElement SELLER_NAME;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup")
    private WebElement ADS_FAVORITE;
    @AndroidFindBy(id = "se.scmv.belarus:id/delete")
    private WebElement DELETE_SEARCH_FROM_FAVORITE_ADS;
    @AndroidFindBy(id = "se.scmv.belarus:id/title")
    private WebElement NAME_TITLE_OF_FAVORITE_SEARCH;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement CONFIRM_DELETE;
    @AndroidFindBy(id = "se.scmv.belarus:id/internalProgressButton")
    private WebElement IS_FOLLOW_BUTTON;

    public Favorites(AndroidDriver driver) {
        super(driver);
    }

    @Step("Login through favorites")
    public void signInOrLogin() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goToFavorites();
        buttons.searchAndClickButtonBy(SIGN_IN_OR_LOGIN);
    }

    @Step("Advert is not visible in favorites?")
    public boolean isNotVisibleAdsInFavorites() {
        goToFavorites();
        buttons.searchAndClickButtonBy(IS_FAVORITE);
        screen.swipe(Direction.DOWN);

        return elements.isNotVisibleElement(ADS_FAVORITE);
    }

    @Step("Go to favorites menu")
    public void goToFavorites() {
        buttons.searchAndClickButtonBy(MENU_FAVORITES);
    }

    @Step("Get advert title in favorite menu")
    public String getAdTitleInFavorite() {
        return elements.getTextFromElement(TITLE_FAVORITE_SEARCH);
    }

    @Step("Choose ads favorites section")
    public void chooseAdsSection() {
        buttons.searchAndClickButtonBy(ADVERTISEMENT);
    }

    @Step("Choose search favorites section")
    public void chooseSearchSection() {
        buttons.searchAndClickButtonBy(SEARCH_FAVORITES);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.swipe(Direction.DOWN);

    }

    @Step("Get name of search favorite")
    public String getNameOfFavoriteSearch() {
        return elements.getTextFromElement(NAME_TITLE_OF_FAVORITE_SEARCH);
    }

    @Step("Delete search from search-favorites")
    public void deleteSearchFromFavorites() {
        buttons.searchAndClickButtonBy(DELETE_SEARCH_FROM_FAVORITE_ADS);
        buttons.searchAndClickButtonBy(CONFIRM_DELETE);
    }

    @Step("Search is not visible?")
    public boolean isNotVisibleSearchInFavorites() {
        return elements.isNotVisibleElement(DELETE_SEARCH_FROM_FAVORITE_ADS);
    }

    @Step("Choose section of favorite sellers")
    public void chooseSellersSection() {
        buttons.searchAndClickButtonBy(SELLERS);
    }

    @Step("Get name of seller in \"Sellers\" section")
    public String getNameOfSeller() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.swipe(Direction.DOWN);
        return elements.getTextFromElement(SELLER_NAME);
    }

    @Step("Unfollow of seller from \"Sellers\" section")
    public void unfollowOfSeller() {
        buttons.searchAndClickButtonBy(IS_FOLLOW_BUTTON);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.swipe(Direction.DOWN);
    }

    @Step("Unfollowed from seller?")
    public boolean isNotVisibleSellerInFavorites() {
        return elements.isNotVisibleElement(IS_FOLLOW_BUTTON);
    }
}
