package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import pages.admin.CustomerGroups;
import utilities.Browser;

/**
 * Class whit which we can print the name of all available groups.
 */
public class AvailableGroups {

    /**
     * Method which opens a browser of your choice.
     */
    @Before
    public void setup() {
        Browser.open("chrome");
    }

    /**
     * Method which print in console the names of all groups. First log in and go to Customer Groups page.
     */
    @Test
    public void PrintNamesOfAllGroups() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");

        CustomerGroups.openCustomerGroupsPage();
        CustomerGroups.printNamesOfGroups();
    }

    /**
     * Method which close browser.
     */
    @After
    public void tearDown() {
        Browser.quit();
    }
}
