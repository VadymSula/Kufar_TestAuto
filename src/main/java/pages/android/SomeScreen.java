package pages.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class SomeScreen extends AndroidBasePage {
    @AndroidFindBy(id = "se.scmv.belarus:id/login")
    private WebElement LOGIN_BUTTON;
    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private WebElement CANCEL_BUTTON;//кнопка "ничего из перечисленного" всплывающее окно
    @AndroidFindBy(id = "se.scmv.belarus:id/avatar")
    private WebElement AVATAR_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Выйти из профиля')]")
    private WebElement LOGOUT_BUTTON;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Перейти вверх\"]")
    private WebElement BACK_BUTTON_PROFILE;
    @AndroidFindBy(xpath = "/hierarchy//android.widget.FrameLayout[1]//android.widget.EditText")
    private WebElement EMAIL_PATH;
    @AndroidFindBy(xpath = "/hierarchy//android.widget.FrameLayout[2]//android.widget.EditText")
    private WebElement PASSWORD_PATH;

    public SomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @Step("logIn your account")
    public void logIn(String email, String password) {
        goToLoginProcess();
        compelledLogIn();
        enterCredentialsAndLogin(email, password);
        goToMyData();
    }

    @Step("logOut your account")
    public void logOut() {
        buttons.searchAndClickButtonBy(MENU_PROFILE);
        buttons.searchAndClickButtonBy(AVATAR_BUTTON);
        screen.scrollablePageAndroid("Выйти");
        buttons.searchAndClickButtonBy(LOGOUT_BUTTON);
    }

    @Step("Search  and click  cancel button after login")
    public void compelledLogIn() {
        buttons.searchAndClickButtonBy(CANCEL_BUTTON);
    }

    @Step("Set credentials and click LogIn button")
    public void enterCredentialsAndLogin(String email, String password) {
        elements.searchFieldAndSendKey(EMAIL_PATH, email);
        elements.searchFieldAndSendKey(PASSWORD_PATH, password);
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
    }

    @Step("Enter to My Data menu")
    private void goToMyData() {
        buttons.searchAndClickButtonBy(AVATAR_BUTTON);
        buttons.searchAndClickButtonBy(BACK_BUTTON_PROFILE);
    }

    @Step("Go to LogIn process")
    private void goToLoginProcess() {
        buttons.searchAndClickButtonBy(MENU_PROFILE);
        buttons.searchAndClickButtonBy(MENU_PROFILE);
        buttons.searchAndClickButtonBy(LOGIN_BUTTON);
    }
}
