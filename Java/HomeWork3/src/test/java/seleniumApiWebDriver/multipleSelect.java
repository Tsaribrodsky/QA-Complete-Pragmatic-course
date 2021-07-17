package seleniumApiWebDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class multipleSelect {

    static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
        driver.manage().window().maximize();
    }

    @Test
    public void multipleSelectTest () {
        WebElement colorRed = driver.findElement(By.xpath("//option[@value='rd']"));
        WebElement colorSilver = driver.findElement(By.xpath("//option[@value='sl']"));

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(colorRed).click(colorSilver).keyUp(Keys.CONTROL).perform();

        Assert.assertTrue(colorRed.isSelected());
        Assert.assertTrue(colorSilver.isSelected());
    }
}
