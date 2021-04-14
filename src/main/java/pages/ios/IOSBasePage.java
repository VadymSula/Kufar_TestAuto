package pages.ios;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IOSBasePage {
    private AppiumDriver driver;

    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;

    public IOSBasePage(AppiumDriver driver) {
        buttons = new Buttons();
        screen = new Screen();
        elements = new Elements();
        this.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Панель вкладок\"`]/XCUIElementTypeButton[5]")
    protected WebElement MENU_PROFILE;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Панель вкладок\"`]/XCUIElementTypeButton[4]")
    protected WebElement MENU_MESSAGES;

    @iOSXCUITFindBy(accessibility = "tabbar_new")
    protected WebElement ADD_ADVERT;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTabBar[`label == \"Панель вкладок\"`]/XCUIElementTypeButton[2]")
    protected WebElement MENU_FAVORITES;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`value == \"1\"`]")
    protected WebElement MENU_LISTING;

    @Step("Go to advertisements list")
    public void goToAdvertisements() {
        buttons.searchAndClickButtonBy(MENU_LISTING);
    }

    @Step("Go to menu profile")
    public void goToMenuProfile() {
        buttons.searchAndClickButtonBy(MENU_PROFILE);
    }

    @Step("Go to favorites")
    public void goToFavorites() {
        buttons.searchAndClickButtonBy(MENU_FAVORITES);
    }

    @Step("Go to messages")
    public void goToMessages() {
        buttons.searchAndClickButtonBy(MENU_MESSAGES);
    }

    @Step("Go to add advert")
    public void goToAddAdvert() {
        buttons.searchAndClickButtonBy(ADD_ADVERT);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }
}
