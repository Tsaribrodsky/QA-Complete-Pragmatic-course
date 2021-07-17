package explicitWaitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class BgMenu {

    static WebDriver driver;

    @Before
    public void setUp () {
//        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addressSearch() {
        driver.get("https://www.bgmenu.com");

        try {
            WebElement searchBox = driver.findElement(By.name("mysearchstring"));
            searchBox.sendKeys("булевард Витоша");
//            WebElement addressForm = driver.findElement(By.cssSelector("form.formstyle"));
//            addressForm.click();
//            searchBox.sendKeys(Keys.ENTER);
            Wait<WebDriver> wait = new WebDriverWait(driver, 10);
            WebElement addressElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("булевард „Витоша“, София")));
            addressElement.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='dropdown-location']/preceding-sibling::dt/span[@class='title-delivery']")));


//            (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>()
//            {
//                public Boolean apply(WebDriver driver) {
//                    JavascriptExecutor js = (JavascriptExecutor)driver;
//                    return (Boolean)js.executeScript("return jQuery.active == 0");
//                }
//            });


        assertTrue("This is wrong page", driver.getTitle().equalsIgnoreCase("Поръчай храна за вкъщи в София 1463 - Takeaway.com"));

        WebElement restaurantUgo = driver.findElement(By.cssSelector("div#irestaurantN3O57Q7 h2.restaurantname"));
        restaurantUgo.click();

        Wait<WebDriver> waitUgo = new WebDriverWait(driver, 10);
        waitUgo.until(ExpectedConditions.titleContains("UGO"));

        assertTrue(driver.getTitle().startsWith("UGO"));
//        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.textToBePresentInElement(searchBox, "булевард „Витоша“, София"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            fail("Element not found!!");
        }
    }

    @Test
    public void restaurantSearch() {
//        addressSearch();
        driver.get("https://www.bgmenu.com/porachai-hrana-1463");
        WebElement restaurantUgo = driver.findElement(By.cssSelector("div#irestaurantN3O57Q7 h2.restaurantname"));
        restaurantUgo.click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("UGO"));

        assertTrue(driver.getTitle().startsWith("UGO"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
