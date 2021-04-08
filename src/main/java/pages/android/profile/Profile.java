package pages.android.profile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;

public class Profile extends AndroidBasePage {
    @AndroidFindBy(xpath = "/hierarchy//android.widget.LinearLayout[3]/android.widget.TextView")
    private WebElement AD;
    @AndroidFindBy(xpath = "/hierarchy//android.widget.LinearLayout[4]/android.widget.TextView")
    private WebElement ORDERS;
    @AndroidFindBy(xpath = "/hierarchy//android.widget.LinearLayout[8]/android.widget.TextView")
    private WebElement SETTINGS;
    @AndroidFindBy(id = "se.scmv.belarus:id/language")
    private WebElement LANGUAGE_DROP_WINDOW;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.TextView")
    private WebElement RUS_LANGUAGE;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[2]/android.widget.TextView")
    private WebElement BEL_LANGUAGE;
    @AndroidFindBy(id = "se.scmv.belarus:id/close")
    private WebElement CLOSE_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]")
    private WebElement BACK_BUTTON;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[1]/android.widget.RadioButton")
    private WebElement BEL_CHECKBOX;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.widget.LinearLayout[2]/android.widget.RadioButton")
    private WebElement RUS_CHECKBOX;

    public Profile(AndroidDriver driver) {
        super(driver);
    }

    @Step("Checking of My ADS menu have anything text ")
    public String haveTextAD() {

        return elements.getTextFromElement(AD);
    }

    @Step("Checking the visibility of My ADS menu")
    public boolean visibleElementAD() {

        return elements.isVisibleElement(AD);
    }

    @Step("Checking of SETTINGS menu have anything text ")
    public String haveTextSettings() {

        return elements.getTextFromElement(SETTINGS);
    }

    @Step("Checking the visibility of My SETTINGS menu")
    public boolean visibleElementSettings() {

        return elements.isVisibleElement(SETTINGS);
    }

    @Step("Search  and click  Settings button ")
    public void openSettings() {
        buttons.searchAndClickButtonBy(SETTINGS);
    }

    @Step("Search  and click  dropdown button with all languages")
    public void clickDropButtonLanguage() {
        buttons.searchAndClickButtonBy(LANGUAGE_DROP_WINDOW);
    }

    @Step("Get attribute Text from element")
    public String checkRusLang() {
        return elements.getTextFromElement(RUS_LANGUAGE);
    }

    @Step("Set Belarusian language")
    public void setBelLanguage() {
        buttons.searchAndClickButtonBy(BEL_LANGUAGE);
    }

    @Step("Set russian language")
    public void setRusLanguage() {
        buttons.searchAndClickButtonBy(RUS_LANGUAGE);
    }

    @Step("Get attribute Text from element")
    public String checkBelLang() {
        return elements.getTextFromElement(BEL_LANGUAGE);
    }

    @Step("Checking the selection of checkbox Belarusian language")
    public boolean isSelectedBelLang() {
        return elements.isSelectedElement(BEL_CHECKBOX);
    }

    @Step("Checking the selection of checkbox russian language")
    public boolean isSelectedRusLang() {
        return elements.isSelectedElement(RUS_CHECKBOX);
    }

    @Step("Search  and click  Close button ")
    public void clickClose() {
        buttons.searchAndClickButtonBy(CLOSE_BUTTON);
    }

    @Step("Search  and click  get back button ")
    public void clickBackButton() throws InterruptedException {
        Thread.sleep(3000);
        buttons.searchAndClickButtonBy(BACK_BUTTON);
    }

    @Step("Search  and click  Menu Profile button ")
    public void clickMenuProfileButton() {
        buttons.searchAndClickButtonBy(MENU_PROFILE);
    }

    @Step("Search  and click My ADS button ")
    public void clickMyAdvertsMenu() {
        buttons.searchAndClickButtonBy(AD);
    }
}
