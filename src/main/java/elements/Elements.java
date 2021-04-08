package elements;

import core.InitialDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Elements {

    private AppiumDriver driver = InitialDriver.getDriver();
    private static Logger log = Logger.getLogger(Elements.class);


    public String getTextFromElement(WebElement webElement) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public boolean isSelectedElement(WebElement element) {
        try {
            element.isSelected();
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public boolean isVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.visibilityOf(webElement));
            log.info("Checking Element");
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public boolean isNotVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(webElement));
            log.info("Checking Element");
            return false;
        } catch (Exception ElementNotVisible) {
            return true;
        }
    }

    public void searchFieldAndSendKey(WebElement webElement, String key) {
        WebElement searchField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(webElement));
        searchField.sendKeys(key);
    }
}
