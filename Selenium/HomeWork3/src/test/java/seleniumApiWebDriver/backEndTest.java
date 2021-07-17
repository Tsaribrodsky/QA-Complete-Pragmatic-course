package seleniumApiWebDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class backEndTest {

    static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @Test
    public void logInTest() {
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[text()=' Login']"));

        username.sendKeys("admin");
        password.sendKeys("parola123!");
        buttonLogin.click();

        if (!"Dashboard".equals(driver.getTitle())) {
//            Assert.assertEquals("Dashboard", driver.getTitle());
            Assert.fail("Invalid username or password!");
        }
//        WebElement navigation = driver.findElement(By.xpath("//div[text()=' Navigation']"));
    }

    @Test
    public void dropDownTest() {
        logInTest();
        WebElement buttonSales = driver.findElement(By.xpath("//a[text()=' Sales']"));
        buttonSales.click();
        WebElement buttonOrders = driver.findElement(By.xpath("//li[@id='menu-sale']//a[text()='Orders']"));
        buttonOrders.click();

        WebElement dropDown = driver.findElement(By.cssSelector("select.form-control"));
        Select orderStatus = new Select(dropDown);
        List<String> expOptions = Arrays.asList("", "Missing Orders", "Canceled", "Canceled Reversal", "Chargeback",
                "Complete", "Denied", "Expired", "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed",
                "Shipped", "Voided");
        List<String> actOptions = new ArrayList<String>();
        List<WebElement> allOptions = orderStatus.getOptions();

        for (WebElement option : allOptions) {
            actOptions.add(option.getText());
        }
        Assert.assertArrayEquals(expOptions.toArray(),actOptions.toArray());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
