import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static final String PAGE_URL = "/home";
    private WebElement userPanel;
    private static final By USER_PANEL_LOCATOR = By.xpath("//div[@class='userpanel-header']");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        pageAction.navigateTo(BASE_URL, PAGE_URL);
    }

    public String getUserPanelText() {
        userPanel = driver.findElement(USER_PANEL_LOCATOR);
        return pageAction.getText(userPanel);
    }
}
