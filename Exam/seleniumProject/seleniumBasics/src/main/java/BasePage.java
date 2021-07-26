import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected PageAction pageAction;
    protected static final String BASE_URL = "http://localhost:9966/petclinic/"; //Website Base URL
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        pageAction = new PageAction(driver);
    }

}
