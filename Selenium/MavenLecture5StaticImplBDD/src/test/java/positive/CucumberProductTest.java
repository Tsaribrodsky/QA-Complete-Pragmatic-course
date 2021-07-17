package positive;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.admin.AdminLogin;
import pages.admin.Products;
import utilities.Browser;

import static org.junit.Assert.assertTrue;

public class CucumberProductTest extends Products {

    @Before
    public void setup() {
        Browser.open("chrome");
    }

    @Given("^open online shop$")
    public void open_online_shop() {
        Browser.driver.get("http://shop.pragmatic.bg/admin");
    }

    @When("^log in as admin$")
    public void log_in_as_admin() {
        AdminLogin.login("admin", "parola123!");
    }

    @When("^open Products page$")
    public void open_Products_page() {
        Browser.driver.findElement(LOC_BUTTON_CATALOG).click();
        Browser.driver.findElement(LOC_LINK_PRODUCTS).click();

        Assert.assertTrue(Browser.driver.getTitle().contains("Products"));
    }

    @When("^try to add new product and check this$")
    public void try_to_add_new_product_and_check_this() {
        Browser.driver.findElement(LOC_BUTTON_ADD_NEW_PRODUCT).click();
        Browser.driver.findElement(LOC_PRODUCT_NAME).sendKeys("Philips 21\"");
        Browser.driver.findElement(LOC_META_TAG_TITLE).sendKeys("Philips 21");
        Browser.driver.findElement(LOC_BUTTON_DATA).click();
        Browser.driver.findElement(LOC_MODEL).sendKeys("Black Edition");
        Browser.driver.findElement(LOC_SAVE_BUTTON).click();

        String successAddProductMessage = Browser.driver.findElement(LOC_SUCCESS_ADD_PRODUCT_MESSAGE).getText();
        Assert.assertTrue(successAddProductMessage.startsWith("Success: You have modified products!"));
    }

    @When("^I filtered this product and select checkbox$")
    public void i_filtered_this_product_and_select_checkbox() {
        Browser.driver.findElement(LOC_FILTER_PRODUCT_NAME).sendKeys("Philips 21\"");
        Browser.driver.findElement(LOC_BUTTON_FILTER).click();

        WebElement checkbox = Browser.driver.findElement(LOC_CHECKBOX_AFTER_FILTER_PRODUCT);
        if (!checkbox.isSelected())
            checkbox.click();
        assertTrue(checkbox.isSelected());

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.elementToBeSelected(LOC_CHECKBOX_AFTER_FILTER_PRODUCT));
    }

    @When("^I click on delete button and check for successful message$")
    public void i_click_on_delete_button_and_check_for_successful_message() {
        Browser.driver.findElement(LOC_BUTTON_DELETE_CHECKED_PRODUCT).click();

        Alert alert = Browser.driver.switchTo().alert();
        alert.accept();

        String successModifiedMessage = Browser.driver.findElement(LOC_SUCCESS_MODIFIED_MESSAGE).getText();
        Assert.assertTrue(successModifiedMessage.startsWith("Success: You have modified products!"));

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOC_SUCCESS_MODIFIED_MESSAGE));
    }

    @After
    public void tearDown() {
        Browser.quit();
    }
}
