package tests.ios.filters;

import core.InitialDriver;
import elements.Screen;
import enums.Direction;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ios.advertisements.Advert;
import pages.ios.filters.Filters;

public class FiltersTest {
    private final String PRICE_FROM = "70000";
    private final String PRICE_TO = "90000";
    private String expectedCountOfRooms;
    Filters filters = new Filters(InitialDriver.getDriver());
    Advert advert = new Advert(InitialDriver.getDriver());
    Screen screen = new Screen();

    @BeforeTest
    public void chooseFiltersAndApply() {
        filters.goToAdvertisements();
        filters.goToFilters();
        filters.chooseApartmentCategory();
        filters.inputPrice(PRICE_FROM, PRICE_TO);
        filters.chooseCountOfRooms();
        expectedCountOfRooms = filters.getCountOfRooms();
        filters.getViewResults();
        filters.goToListView();
        filters.goToFirstAdvert();
    }

    @Test
    public void priceIsResponsibleForRange() {
        int priceFrom = Integer.parseInt(PRICE_FROM);
        int priceTo = Integer.parseInt(PRICE_TO);
        boolean isBetweenAnd = priceFrom <= advert.getActualPriceUSD() && advert.getActualPriceUSD() <= priceTo;
        Assert.assertTrue(isBetweenAnd);
    }

    @Test(priority = 1)
    public void countOfRoomsIsEquals() {
        screen.swipe(Direction.UP);
        String actualCountOfRooms = filters.getCountOfRooms();

        Assert.assertEquals(actualCountOfRooms, expectedCountOfRooms);
    }
}
