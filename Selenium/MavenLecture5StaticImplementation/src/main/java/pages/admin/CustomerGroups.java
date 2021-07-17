package pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Browser;
import java.util.List;
import static pages.admin.Customers.LOC_MENU_BUTTON_CUSTOMERS;

/**
 * <h1>CustomerGroups</h1>
 * Class which can print the names of all groups in console, if someone need this.
 */
public class CustomerGroups {

    private static final By LOC_LINK_CUSTOMER_GROUPS = By.xpath("//li[@id='menu-customer']//a[text()='Customer Groups']");
    private static final By LOC_NAMES_OF_GROUPS = By.cssSelector("tbody td.text-left");

    /**
     * Method which open Customer Groups page.
     */
    public static void openCustomerGroupsPage() {
        Browser.driver.findElement(LOC_MENU_BUTTON_CUSTOMERS).click();
        Browser.driver.findElement(LOC_LINK_CUSTOMER_GROUPS).click();

        Assert.assertTrue(Browser.driver.getTitle().contains("Customer Groups"));
    }

    /**
     * Method which get and print the names of all groups in console.
     */
    public static void printNamesOfGroups() {
        List<WebElement> namesOfGroups = Browser.driver.findElements(LOC_NAMES_OF_GROUPS);

        for (WebElement groupName : namesOfGroups) {
            System.out.println(groupName.getText());
        }
    }
}
