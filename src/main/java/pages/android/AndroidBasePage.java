package pages.android;

import elements.Buttons;
import elements.Elements;
import elements.Screen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AndroidBasePage {
    private AndroidDriver driver;

    protected Buttons buttons;
    protected Screen screen;
    protected Elements elements;

    public AndroidBasePage(AndroidDriver driver) {
        buttons = new Buttons();
        screen = new Screen();
        elements = new Elements();
        this.setDriver(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "se.scmv.belarus:id/menu_favorites")
    protected WebElement MENU_FAVORITES;

    @AndroidFindBy(id = "se.scmv.belarus:id/menu_listing")
    protected WebElement MENU_LISTING;

    @AndroidFindBy(id = "se.scmv.belarus:id/menu_add")
    protected WebElement ADD_ADVERT;

    @AndroidFindBy(id = "se.scmv.belarus:id/menu_messages")
    protected WebElement MENU_MESSAGES;

    @AndroidFindBy(id = "se.scmv.belarus:id/menu_profile")
    protected WebElement MENU_PROFILE;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }
}
