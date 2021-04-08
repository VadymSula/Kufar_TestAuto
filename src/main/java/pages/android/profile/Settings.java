package pages.android.profile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.android.AndroidBasePage;

public class Settings extends AndroidBasePage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.view.ViewGroup[3]/android.widget.ImageView")
    private WebElement MY_PAY_CARDS;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.view.ViewGroup[1]/android.widget.ImageView")
    private WebElement MY_DATA;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout//android.view.ViewGroup[2]/android.widget.ImageView")
    private WebElement KUFAR_PAYMENT;
    @AndroidFindBy(id = "se.scmv.belarus:id/addCard")
    private WebElement ADD_NEW_CARDS_BUTTON;

    @AndroidFindBy(xpath = "/hierarchy//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.EditText")
    private WebElement NUMBER_CARD_FIELD;
    @AndroidFindBy(xpath = "/hierarchy//android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText")
    private WebElement OWNER_NAME_FIELD;
    @AndroidFindBy(xpath = "/hierarchy//android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText")
    private WebElement VALIDITY_CARD_FIELD;
    @AndroidFindBy(xpath = "/hierarchy//android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText")
    private WebElement CVC_FIELD;
    @AndroidFindBy(xpath = "/hierarchy//android.view.View[5]/android.widget.Button")
    private WebElement ADD_CARD_BUTTON;


    public Settings(AndroidDriver driver) {
        super(driver);
    }

    @Step("Search  and click My Pay Cards button ")
    public void clickMyPayCardsButton() {
        buttons.searchAndClickButtonBy(MY_PAY_CARDS);
    }

    @Step("Checking the visibility of Add New Card button")
    public boolean checkAddNewCardButton() {
        return elements.isVisibleElement(ADD_NEW_CARDS_BUTTON);
    }

    public void clickAddNewCardButton() {
        buttons.searchAndClickButtonBy(ADD_NEW_CARDS_BUTTON);
    }

    @Step("Checking the visibility of Number Card field")
    public boolean checkNumberCardField() {
        return elements.isVisibleElement(NUMBER_CARD_FIELD);
    }

    @Step("Checking the visibility of Owner Name field")
    public boolean checkOwnerNameField() {
        return elements.isVisibleElement(OWNER_NAME_FIELD);
    }

    @Step("Checking the visibility of Validity Card field")
    public boolean checkValidityCardField() {
        return elements.isVisibleElement(VALIDITY_CARD_FIELD);
    }

    @Step("Checking the visibility of CVC field")
    public boolean checkCvcField() {
        return elements.isVisibleElement(CVC_FIELD);
    }

    @Step("Checking the visibility of Add Card button")
    public boolean checkAddCardButton() {
        return elements.isVisibleElement(ADD_CARD_BUTTON);
    }
}
