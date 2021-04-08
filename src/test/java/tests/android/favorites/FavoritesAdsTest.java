package tests.android.favorites;

import core.InitialDriver;
import enums.Credentials;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.android.SomeScreen;
import pages.android.advertisements.Advert;
import pages.android.advertisements.Advertisements;
import pages.android.favorites.Favorites;

public class FavoritesAdsTest {
    Favorites favorites = new Favorites((AndroidDriver) InitialDriver.getDriver());
    Advertisements advertisements = new Advertisements((AndroidDriver) InitialDriver.getDriver());
    Advert advert = new Advert((AndroidDriver) InitialDriver.getDriver());
    SomeScreen someScreen = new SomeScreen((AndroidDriver) InitialDriver.getDriver());

    @BeforeTest
    public void logIn() {
        favorites.signInOrLogin();
        someScreen.compelledLogIn();
        someScreen.enterCredentialsAndLogin(Credentials.EMAIL.getType(), Credentials.PASS.getType());
    }

    @Test
    @Owner(value = "Vadym Sula")
    @Description("Check on conformity title's added advert to favorites")
    public void addAdvertToFavorites() {
        advertisements.goToAdvertisements();
        advertisements.goToFirstAdvert();
        advert.addAdToFavorites();
        String expectedAdTitle = advert.getAdTitle();
        advert.goBack();
        advertisements.goToFavorites();
        favorites.chooseAdsSection();
        String actualAdTitle = favorites.getAdTitleInFavorite();

        Assert.assertEquals(expectedAdTitle, actualAdTitle);
    }

    @Test(dependsOnMethods = "addAdvertToFavorites")
    @Owner(value = "Vadym Sula")
    @Description("Check on success unlike advert from favorites")
    public void unlikedAdvertFromFavorites() {
        Assert.assertTrue(favorites.isNotVisibleAdsInFavorites());
    }

    @AfterTest
    public void logOut() {
        someScreen.logOut();
    }
}
