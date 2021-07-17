package pages.admin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Browser;

/**
 * <h1>HomeDashboardDevSettings</h1>
 * This class check for successful theme refresh in Developer Settings.
 * @author Dani Tsaribrodski
 */
public class HomeDashboardDevSettings {

    private static final By LOC_BUTTON_DEV_SETTING = By.cssSelector("button#button-setting>i.fa");
    private static final By LOC_BUTTON_THEME_REFRESH = By.xpath("//button[@value='theme']/i");
    private static final By LOC_MESSAGE_ALERT = By.cssSelector("div.alert-success");

    /**
     * Method which open Developer Settings.
     */
    public static void openDeveloperSettings() {
        Browser.driver.findElement(LOC_BUTTON_DEV_SETTING).click();

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    /**
     * Method which clear theme cache and check for display a successful alert message.
     */
    public static void ThemeRefresh() {
        Browser.driver.findElement(LOC_BUTTON_THEME_REFRESH).click();

        Wait<WebDriver> wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOC_MESSAGE_ALERT));

        String successfulRefreshMessage = Browser.driver.findElement(LOC_MESSAGE_ALERT).getText();
        Assert.assertTrue(successfulRefreshMessage.startsWith("Success: You have cleared the theme cache!"));
    }
}
