package tests.android.profilePageTests;

import core.InitialDriver;
import enums.Credentials;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.android.profile.Profile;
import pages.android.SomeScreen;

public class SettingsPageTests {
    SomeScreen someScreen = new SomeScreen((AndroidDriver) InitialDriver.getDriver());
    Profile profile = new Profile((AndroidDriver) InitialDriver.getDriver());

    @BeforeTest
    public void setCap() {
        someScreen.logIn(Credentials.EMAIL.getType(), Credentials.PASS.getType());
    }

    @Test
    @Owner("Katlinski Aliaksei")
    public void languageMenuTest() throws InterruptedException {
        SoftAssert softAssertion = new SoftAssert();
        profile.clickMenuProfileButton();
        profile.openSettings();
        profile.clickDropButtonLanguage();
        softAssertion.assertEquals(profile.checkRusLang(), "Русский");
        softAssertion.assertEquals(profile.checkBelLang(), "Беларуская");
        softAssertion.assertAll();
        profile.clickClose();
        profile.clickBackButton();
    }

    @Test
    @Owner("Katlinski Aliaksei")
    public void checkSelectLanguageTest() throws InterruptedException {
        profile.clickMenuProfileButton();
        profile.openSettings();
        profile.clickDropButtonLanguage();
        profile.setBelLanguage();
        profile.clickDropButtonLanguage();
        Assert.assertTrue(profile.isSelectedBelLang());
        profile.setRusLanguage();
        profile.clickDropButtonLanguage();
        Assert.assertTrue(profile.isSelectedRusLang());
        profile.clickClose();
        profile.clickBackButton();
    }

    @AfterTest
    public void logOut() {
        someScreen.logOut();
    }
}
