package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import pages.admin.Customers;
import utilities.Browser;

/**
 * <h1>EditCustomerTest</h1>
 * Class for test changing customer group.
 * @author Dani Tsaribrodski
 */
public class EditCustomerTest {

    /**
     * Method which opens a browser of your choice.
     */
    @Before
    public void setup() {
        Browser.open("chrome");
    }

    /**
     * Method which test changing customer group. But first open admin login form and successful log in. Then open Customer List.
     */
    @Test
    public void changeCustomerGroup() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");

        Customers.openCustomersPage();
        Customers.editCustomer();
        Customers.changeCustomerGroup();
    }

    /**
     * Method which close browser.
     */
    @After
    public void tearDown() {
        Browser.quit();
    }
}
