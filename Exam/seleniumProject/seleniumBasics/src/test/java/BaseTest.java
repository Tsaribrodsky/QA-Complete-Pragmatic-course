import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe"; //Chrome driver name
    public static final String WEB_DRIVERS_LOCATION = "D:\\drivers\\"; //Driver location
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver"; //Property name
    protected WebDriver driver;

    public BaseTest (){
        initBrowser();
    }

    public void initBrowser() {
        System.out.println("Configuring browser properties");
        System.setProperty(CHROME_PROPERTY, WEB_DRIVERS_LOCATION + CHROME_DRIVER_NAME);
        driver = new ChromeDriver(); //Creates new driver instance
        driver.manage().deleteAllCookies(); //Deletes browser cookies
        driver.manage().window().maximize(); //Maximizes browser
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //Implicit wait if element is not there
    }

    public void quitBrowser() {
        driver.quit();
    }


}
