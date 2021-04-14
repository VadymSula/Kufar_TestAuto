package pages.android.advertisements;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;
import utils.PriceParser;

public class Advert extends AndroidBasePage {
    @AndroidFindBy(id = "se.scmv.belarus:id/favoriteIcon")
    private WebElement FAVORITE_ICON;
    @AndroidFindBy(id = "se.scmv.belarus:id/title")
    private WebElement AD_TITLE;
    @AndroidFindBy(id = "se.scmv.belarus:id/priceByn")
    private WebElement AD_PRICE;
    @AndroidFindBy(id = "se.scmv.belarus:id/adId")
    private WebElement AD_ID;
    @AndroidFindBy(id = "se.scmv.belarus:id/userInfoContainer")
    private WebElement SELLER_INFO;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Подписаться']")
    private WebElement FOLLOW_BUTTON;
    @AndroidFindBy(accessibility = "Перейти вверх")
    private WebElement BACK_BUTTON;
    @AndroidFindBy(id = "se.scmv.belarus:id/priceUsd")
    private WebElement PRICE_USD;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Количество комнат']/following-sibling::android.widget.TextView")
    private WebElement COUNT_OF_ROOMS;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Категория']/following-sibling::android.widget.TextView")
    private WebElement NAME_OF_CATEGORY;
    @AndroidFindBy(id = "se.scmv.belarus:id/name")
    private WebElement NAME_OF_SELLER;

    public Advert(AndroidDriver driver) {
        super(driver);
    }

    @Step("Add advert to favorites")
    public void addAdToFavorites() {
        buttons.searchAndClickButtonBy(FAVORITE_ICON);
        buttons.clickButtonBackOnKeyboard((AndroidDriver) getDriver());
    }

    @Step("Get advert title")
    public String getAdTitle() {
        return elements.getTextFromElement(AD_TITLE);
    }

    @Step("Get advert price")
    public String getAdPrice() {
        return elements.getTextFromElement(AD_PRICE);
    }

    @Step("Get advert ID")
    public String getAdId() {
        return elements.getTextFromElement(AD_ID);
    }

    @Step("Choose seller and go to him")
    public void goToSeller() {
        screen.scrollablePageAndroid("Подписаться");
        buttons.searchAndClickButtonBy(SELLER_INFO);
    }

    @Step("Go to information about seller")
    public void goToSellerInfo() {
        screen.scrollablePageAndroid("Подписаться");
    }

    @Step("Get name of seller")
    public String getNameOfSeller() {
        return elements.getTextFromElement(NAME_OF_SELLER);
    }

    @Step("Follow on seller")
    public void followOnSeller() {
        buttons.searchAndClickButtonBy(FOLLOW_BUTTON);
    }

    @Step("Get price in USD")
    public int getPriceUSD() {
        return Integer.parseInt(PriceParser.androidParsePriceUSD(getPriceUSDInStringFormat()));
    }

    private String getPriceUSDInStringFormat() {
        screen.scrollablePageAndroid("$");
        return elements.getTextFromElement(PRICE_USD);
    }

    @Step("Go back!")
    public void goBack() {
        buttons.searchAndClickButtonBy(BACK_BUTTON);
    }

    @Step("Get count rooms of apartment from advert")
    public String getCountOfRoomsFromAdvert() {
        screen.scrollablePageAndroid("Количество комнат");
        return elements.getTextFromElement(COUNT_OF_ROOMS);
    }

    @Step("Get name of category from advert")
    public String getNameOfCategoryFromAdvert() {
        screen.scrollablePageAndroid("Категория");
        return elements.getTextFromElement(NAME_OF_CATEGORY);
    }
}
