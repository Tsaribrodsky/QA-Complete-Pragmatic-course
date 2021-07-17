package explicitWaitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class homework4wait {

    static WebDriver driver;

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bgmenu.com");
    }

    @Test
    public void addressSearch() {

        try {
            WebElement searchBox = driver.findElement(By.cssSelector("#imysearchstring"));
            searchBox.sendKeys("булевард „Витоша“, София");
            WebElement addressForm = driver.findElement(By.cssSelector("form.formstyle"));
            addressForm.click();
            searchBox.sendKeys(Keys.ENTER);

            (new WebDriverWait(driver,15)).until(new ExpectedCondition<Boolean>()
            {
                public Boolean apply(WebDriver driver) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return (Boolean)js.executeScript("return jQuery.active == 0");
                }
            });

//            assertTrue("This is wrong page", driver.getTitle().equalsIgnoreCase("Поръчай храна за вкъщи в София 1463 - BGmenu.com"));
//        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.elementToBeClickable(restaurantUgo));
//            assertEquals("Поръчай храна за вкъщи в София 1463 - BGmenu.com", driver.getTitle());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Element not found!!");
        }
    }

    @Test
    public void restaurantSearch() {
        addressSearch();
        WebElement restaurantUgo = driver.findElement(By.id("irestaurantN3O57Q7"));
        restaurantUgo.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(restaurantUgo));
    }

//    @After
//    public void tearDown() {
//        driver.close();
//    }
}
