package pages.ios.advertisements;

import enums.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.ios.IOSBasePage;
import utils.PriceParser;

public class Advert extends IOSBasePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[1]")
    private WebElement NAME_OF_ADVERT;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[`label CONTAINS \"$\"`]")
    private WebElement PRICE_USD;
    @iOSXCUITFindBy(xpath = "XCUIElementTypeStaticText[@name=\"Количество комнат\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private WebElement COUNT_OF_ROOMS_TEXT;

    public Advert(AppiumDriver driver) {
        super(driver);
    }

    public String getNameOfAdvert() {
        return elements.getTextFromElement(NAME_OF_ADVERT);
    }

    public int getActualPriceUSD() {
        return Integer.parseInt(PriceParser.iosParsePriceUSD(elements.getTextFromElement(PRICE_USD)));
    }

    public String getActualCountOfRooms() {
        return elements.getTextFromElement(COUNT_OF_ROOMS_TEXT);
    }
}
