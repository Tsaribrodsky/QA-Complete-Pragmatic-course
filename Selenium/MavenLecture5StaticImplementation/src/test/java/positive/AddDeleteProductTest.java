package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import pages.admin.Products;
import utilities.Browser;

/**
 * <h1>AddDeleteProductTest</h1>
 * Class which test add and delete product.
 * @author Dani Tsaribrodski
 */
public class AddDeleteProductTest {

    /**
     * Method which opens a browser of your choice.
     */
    @Before
    public void setup() {
        Browser.open("chrome");
    }

    /**
     * Method which test add and delete product. First log in. Then open Products page, add new product,
     * search this new product by filter, select checkbox and delete this product.
     */
    @Test
    public void AddDeleteProduct() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");

        Products.openProductsPage();
        Products.addNewProduct();
        Products.selectCheckbox();
        Products.deleteProduct();
    }

    /**
     * Method which close browser.
     */
    @After
    public void tearDown() {
        Browser.quit();
    }
}
