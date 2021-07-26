import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageAction {
    private WebDriver driver;

    public PageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void typeText(WebElement field, String text) {
        System.out.println("Typing text:" + text);
        field.clear();
        field.sendKeys(text);
    }

    public void clickButton(WebElement button) {
        System.out.println("Clicking button:" + button.getText());
        button.click();
    }

    public String getText(WebElement element) {
        return element.getText().trim();
    }

    public void navigateTo(String BASE_URL, String page) {
        System.out.println("Navigating to page:" + BASE_URL + page);
        driver.navigate().to(BASE_URL + page);
    }
}
