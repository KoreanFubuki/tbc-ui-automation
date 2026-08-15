package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.pages.LocationsPage;
import org.testng.annotations.Test;

public class LocationsFilterTest extends BaseTest {
    @Test(description = "Locations can be filtered to branches")
    public void branchFilterCanBeSelected() {
        LocationsPage page = new LocationsPage(driver).open();
        page.selectBranchFilter();
        page.waitForFilterState(page.branchFilter());
    }

    @Test(description = "Locations can be filtered to ATMs")
    public void atmFilterCanBeSelected() {
        LocationsPage page = new LocationsPage(driver).open();
        page.selectAtmFilter();
        page.waitForFilterState(page.atmFilter());
    }
}
