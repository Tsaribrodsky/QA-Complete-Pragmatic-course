import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import pages.admin.AdminLogin;
import pages.admin.Products;
import utilities.Browser;

public class MyStepdefs extends Products {

    @Before
    public void setup() {
        Browser.open("chrome");
    }

    @Given("^open online shop$")
    public void openOnlineShop() {
        Browser.driver.get("http://shop.pragmatic.bg/admin");
    }

    @When("^log in as admin$")
    public void logInAsAdmin() {
        AdminLogin.login("admin", "parola123!");
    }

    @When("^open Products page$")
    public static void openProductsPage() {
        Browser.driver.findElement(LOC_BUTTON_CATALOG).click();
        Browser.driver.findElement(LOC_LINK_PRODUCTS).click();

        Assert.assertTrue(Browser.driver.getTitle().contains("Products"));
    }

    @When("^I filtered this product and select checkbox$")
    public void iFilteredThisProductAndSelectCheckbox() {
    }

    @When("^I click on delete button and check for successful message$")
    public void iClickOnDeleteButtonAndCheckForSuccessfulMessage() {
    }

    @When("^try to add new product and check this$")
    public void tryToAddNewProductAndCheckThis() {
    }

    @After
    public void tearDown() {
        Browser.quit();
    }
}
