package tests.ios.filters;

import core.InitialDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ios.filters.Filters;

public class FiltersTest {
    private final String PRICE_FROM = "70000";
    private final String PRICE_TO = "90000";
    Filters filters = new Filters((IOSDriver) InitialDriver.getDriver());

    @Test
    public void chooseFiltersAndApply() {
        filters.goToAdvertisements();
        filters.goToFilters();
        filters.chooseApartmentCategory();
        filters.inputPrice(PRICE_FROM, PRICE_TO);
        filters.chooseCountOfRooms();
        filters.getViewResults();
        filters.goToListView();
        Assert.assertTrue(true);
    }
}
