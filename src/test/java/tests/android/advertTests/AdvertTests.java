package tests.android.advertTests;

import core.InitialDriver;
import enums.Credentials;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.android.SomeScreen;
import pages.android.newAdverts.NewAdvert;
import pages.android.profile.Profile;

public class AdvertTests {
    Profile profile = new Profile((AndroidDriver) InitialDriver.getDriver());
    NewAdvert advert = new NewAdvert((AndroidDriver) InitialDriver.getDriver());
    SomeScreen someScreen = new SomeScreen((AndroidDriver) InitialDriver.getDriver());

    @BeforeTest
    public void setCap() {
        someScreen.logIn(Credentials.EMAIL.getType(), Credentials.PASS.getType());
    }

    @Test
    @Owner("Katlinski Aliaksei")
    public void addNewAdvertHuaweiForSaleTest() throws InterruptedException {
        advert.addNewAdvertHuaweiPhoneForSale();
        profile.clickBackButton();
        profile.clickMenuProfileButton();
        profile.clickMyAdvertsMenu();
        Assert.assertTrue(advert.checkHuaweiAdvertInModeration()
                || advert.checkHuaweiAdvertIsActive());
        profile.clickBackButton();
    }

    @AfterTest
    public void logOut() {
        someScreen.logOut();
    }
}
