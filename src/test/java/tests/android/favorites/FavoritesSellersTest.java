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

public class FavoritesSellersTest {
    Favorites favorites = new Favorites((AndroidDriver) InitialDriver.getDriver());
    SomeScreen someScreen = new SomeScreen((AndroidDriver) InitialDriver.getDriver());
    Advert advert = new Advert((AndroidDriver) InitialDriver.getDriver());
    Advertisements advertisements = new Advertisements((AndroidDriver) InitialDriver.getDriver());

    @BeforeTest
    public void logIn() {
        favorites.signInOrLogin();
        someScreen.compelledLogIn();
        someScreen.enterCredentialsAndLogin(Credentials.EMAIL.getType(), Credentials.PASS.getType());
    }

    @Test
    @Owner(value = "Vadym Sula")
    @Description("Check on success following on seller and conformity his name before/after follow")
    public void followingOnSeller() {
        advertisements.goToAdvertisements();
        advertisements.goToFirstAdvert();
        advert.goToSellerInfo();
        String expectedNameOfSeller = advert.getNameOfSeller();
        advert.followOnSeller();
        advert.goBack();
        advertisements.goToFavorites();
        favorites.chooseSellersSection();

        String actualNameOfSeller = favorites.getNameOfSeller();
        Assert.assertEquals(expectedNameOfSeller, actualNameOfSeller);
    }

    @Test
    @Owner(value = "Vadym Sula")
    @Description("Check on success unfollowing from seller")
    public void unfollowFromSeller() {
        favorites.unfollowOfSeller();

        Assert.assertTrue(favorites.isNotVisibleSellerInFavorites());
    }

    @AfterTest
    public void logOut() {
        someScreen.logOut();
    }
}
