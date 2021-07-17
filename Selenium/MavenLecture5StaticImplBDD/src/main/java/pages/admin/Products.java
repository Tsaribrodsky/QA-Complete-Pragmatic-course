package pages.admin;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Browser;
import static org.junit.Assert.assertTrue;

/**
 * <h1>Products</h1>
 * This class help for open Products page, add new product, select checkbox and delete product.
 * @author Dani Tsaribrodski
 */
public class Products {

    protected static final By LOC_BUTTON_CATALOG = By.xpath("//a[text()=' Catalog']");
    protected static final By LOC_LINK_PRODUCTS = By.xpath("//li[@id='menu-catalog']//a[text()='Products']");
    protected static final By LOC_BUTTON_ADD_NEW_PRODUCT = By.cssSelector("i.fa-plus");
    protected static final By LOC_PRODUCT_NAME = By.cssSelector("input#input-name1");
    protected static final By LOC_META_TAG_TITLE = By.cssSelector("input#input-meta-title1");
    protected static final By LOC_BUTTON_DATA = By.xpath("//li/a[text()='Data']");
    protected static final By LOC_MODEL = By.cssSelector("input#input-model");
    protected static final By LOC_SAVE_BUTTON = By.cssSelector("i.fa-save");
    protected static final By LOC_SUCCESS_ADD_PRODUCT_MESSAGE = By.cssSelector("div.alert-success");
    protected static final By LOC_FILTER_PRODUCT_NAME = By.cssSelector("input#input-name");
    protected static final By LOC_BUTTON_FILTER = By.cssSelector("button#button-filter");
    protected static final By LOC_CHECKBOX_AFTER_FILTER_PRODUCT = By.xpath("//tbody//input[@type='checkbox']");
    protected static final By LOC_BUTTON_DELETE_CHECKED_PRODUCT = By.cssSelector("i.fa-trash-o");
    protected static final By LOC_SUCCESS_MODIFIED_MESSAGE = By.cssSelector("div.alert-success");

    /**
     * Method which open Products page.
     */
    public static void openProductsPage() {
        Browser.driver.findElement(LOC_BUTTON_CATALOG).click();
        Browser.driver.findElement(LOC_LINK_PRODUCTS).click();

        Assert.assertTrue(Browser.driver.getTitle().contains("Products"));
    }

    /**
     * Method which add new product and check for successful message.
     */
    public static void addNewProduct() {
        Browser.driver.findElement(LOC_BUTTON_ADD_NEW_PRODUCT).click();
        Browser.driver.findElement(LOC_PRODUCT_NAME).sendKeys("Philips 21\"");
        Browser.driver.findElement(LOC_META_TAG_TITLE).sendKeys("Philips 21");
        Browser.driver.findElement(LOC_BUTTON_DATA).click();
        Browser.driver.findElement(LOC_MODEL).sendKeys("Black Edition");
        Browser.driver.findElement(LOC_SAVE_BUTTON).click();

        String successAddProductMessage = Browser.driver.findElement(LOC_SUCCESS_ADD_PRODUCT_MESSAGE).getText();
        Assert.assertTrue(successAddProductMessage.startsWith("Success: You have modified products!"));
    }

    /**
     * Method which filtered new product and select checkbox.
     */
    public static void selectCheckbox() {
        Browser.driver.findElement(LOC_FILTER_PRODUCT_NAME).sendKeys("Philips 21\"");
        Browser.driver.findElement(LOC_BUTTON_FILTER).click();

        WebElement checkbox = Browser.driver.findElement(LOC_CHECKBOX_AFTER_FILTER_PRODUCT);
        if (!checkbox.isSelected())
            checkbox.click();
        assertTrue(checkbox.isSelected());

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.elementToBeSelected(LOC_CHECKBOX_AFTER_FILTER_PRODUCT));
    }

    /**
     * Method which delete product. Clicks on a delete button, accept alert window, and check for
     * successful message.
     */
    public static void deleteProduct() {
        Browser.driver.findElement(LOC_BUTTON_DELETE_CHECKED_PRODUCT).click();

        Alert alert = Browser.driver.switchTo().alert();
        alert.accept();

        String successModifiedMessage = Browser.driver.findElement(LOC_SUCCESS_MODIFIED_MESSAGE).getText();
        Assert.assertTrue(successModifiedMessage.startsWith("Success: You have modified products!"));

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOC_SUCCESS_MODIFIED_MESSAGE));
    }
}
