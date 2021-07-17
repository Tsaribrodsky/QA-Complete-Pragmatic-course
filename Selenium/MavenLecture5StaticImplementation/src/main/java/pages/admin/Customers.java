package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Browser;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * <h1>Customers</h1>
 * Class represents Customers page and changing customer group.
 * @author Dani Tsaribrodski
 */
public class Customers {

    static final By LOC_MENU_BUTTON_CUSTOMERS = By.xpath("//a[text()=' Customers']");
    private static final By LOC_LINK_CUSTOMERS = By.xpath("//li[@id='menu-customer']//a[text()='Customers']");
    private static final By LOC_BUTTON_EDIT = By.xpath("//td[contains(text(), 'Hoang Le Xuan ')]/following-sibling::td/div/a");
    private static final By LOC_CUSTOMER_DETAILS =By.xpath("//legend[contains(text(),'Customer Details')]");
    private static final By LOC_DROPDOWN_CUSTOMER_GROUP = By.cssSelector("select#input-customer-group");
    private static final By LOC_SAVE_BUTTON = By.cssSelector("i.fa-save");
    private static final By LOC_SUCCESS_MODIFIED_MESSAGE = By.cssSelector("div.alert-success");
    private static final By LOC_DOUBLE_CHECK_CHANGE_GROUP = By.xpath("//td[contains(text(), 'Hoang Le Xuan ')]/following-sibling::td[contains(text(), 'nova')]");

    /**
     * Method which open Customers page and check title.
     */
    public static void openCustomersPage() {
        Browser.driver.findElement(LOC_MENU_BUTTON_CUSTOMERS).click();
        Browser.driver.findElement(LOC_LINK_CUSTOMERS).click();

        Assert.assertTrue(Browser.driver.getTitle().contains("Customers"));
    }

    /**
     * Method which click on Edit button, open Customer List and check whether is on the right page by web element.
     */
    public static void editCustomer() {
        Browser.driver.findElement(LOC_BUTTON_EDIT).click();

        String checkTextCustomerDetails = Browser.driver.findElement(LOC_CUSTOMER_DETAILS).getText();
        Assert.assertTrue(checkTextCustomerDetails.startsWith("Customer Details"));
    }

    /**
     * Method which select group that we want and check this. Click on save button. Check for successful
     * alert message and whether group is the one we have changed.
     */
    public static void changeCustomerGroup() {
//        Browser.driver.findElement(LOC_DROPDOWN_CUSTOMER_GROUP).click();
        Select changeGroup = new Select(Browser.driver.findElement(LOC_DROPDOWN_CUSTOMER_GROUP));
        changeGroup.selectByVisibleText("nova");
        assertEquals("nova", changeGroup.getFirstSelectedOption().getText());

        Browser.driver.findElement(LOC_SAVE_BUTTON).click();
        String successModifiedMessage = Browser.driver.findElement(LOC_SUCCESS_MODIFIED_MESSAGE).getText();
        Assert.assertTrue(successModifiedMessage.startsWith("Success: You have modified customers!"));

        String anotherCheck = Browser.driver.findElement(LOC_DOUBLE_CHECK_CHANGE_GROUP).getText();
        Assert.assertTrue(anotherCheck.startsWith("nova"));
    }
}
