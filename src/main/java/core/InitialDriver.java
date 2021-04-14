package core;

import configs.PropertiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitialDriver {
    static AppiumDriver driver;
    static DesiredCapabilities cap = new DesiredCapabilities();
    private static Logger log = Logger.getLogger(InitialDriver.class);

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                driver = initializeDriver();
                log.info("Driver is started");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    private static AppiumDriver initializeDriver() throws MalformedURLException {
        setCapabilities();
        return new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    private static void setCapabilities() {
        switch (PropertiesConfig.getProperty("platform").toUpperCase()) {
            case "ANDROID":
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("deviceName"));
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("platformName"));
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("platformVersion"));
                cap.setCapability(MobileCapabilityType.NO_RESET, false);
                cap.setCapability("autoGrandPermission", true);
                cap.setCapability("appPackage", PropertiesConfig.getProperty("myAppPackage"));
                cap.setCapability("appActivity", PropertiesConfig.getProperty("myAppActivity"));
                break;
            case "IOS":
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesConfig.getProperty("iosDeviceName"));
                cap.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesConfig.getProperty("iosPlatformName"));
                cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertiesConfig.getProperty("iosPlatformVersion"));
                cap.setCapability(MobileCapabilityType.NO_RESET, true);
                cap.setCapability(MobileCapabilityType.UDID, PropertiesConfig.getProperty("iosUdId"));
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesConfig.getProperty("iosAutomationName"));
                cap.setCapability("bundleId", PropertiesConfig.getProperty("iosBundleId"));
                break;
            default:
                log.info("Driver is not initialize");
                break;
        }
    }
}
