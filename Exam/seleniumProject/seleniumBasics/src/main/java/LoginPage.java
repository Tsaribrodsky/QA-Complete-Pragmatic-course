import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final String PAGE_URL = "owners/find.html";
    private static final By EMAIL_FIELD_LOCATOR = By.id("lastName");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("loginpassword");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("loginsubmit");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@class='selenium-error-block']");
    private static final By ADD_OWNER_LINK_LOCATOR = By.xpath("//a[text()='Add Owner']");
    private static final By FIRST_NAME_BOX_LOCATOR = By.id("firstName");
    private static final By LAST_NAME_BOX_LOCATOR = By.id("lastName");
    private static final By ADDRESS_BOX_LOCATOR = By.id("address");
    private static final By CITY_BOX_LOCATOR = By.id("city");
    private static final By TELEPHONE_LOCATOR = By.id("telephone");
    private static final By ADD_OWNER_BUTTON_LOCATOR = By.xpath("//button[text()='Add Owner']");


    private WebElement passwordField;
    private WebElement emailField;
    private WebElement loginButton;
    private WebElement badLoginMessage;
    private WebElement addOwner;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement addressField;
    private WebElement cityField;
    private WebElement telephoneField;
    private WebElement addOwnerButton;


    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void gotoPage() {
        pageAction.navigateTo(BASE_URL, PAGE_URL);
    }

    public void enterEmail(String email) {
        emailField = driver.findElement(EMAIL_FIELD_LOCATOR);
        pageAction.typeText(emailField, email);
    }

    public void clickAddOwnerLink() {
        addOwner = driver.findElement(ADD_OWNER_LINK_LOCATOR);
        pageAction.clickButton(addOwner);
    }


    public void enterPassword(String password) {
        passwordField = driver.findElement(PASSWORD_FIELD_LOCATOR);
        pageAction.typeText(passwordField, password);
    }

    public void enterFirstName(String firstName) {
        firstNameField = driver.findElement(FIRST_NAME_BOX_LOCATOR);
        pageAction.typeText(firstNameField, firstName);
    }

    public void clickLoginButton() {
        loginButton = driver.findElement(LOGIN_BUTTON_LOCATOR);
        pageAction.clickButton(loginButton);
    }

    public String getBadLoginErrorMessage() {
        badLoginMessage = driver.findElement(ERROR_MESSAGE_LOCATOR);
        return pageAction.getText(badLoginMessage);
    }

    public void enterLastName(String lastName) {
        lastNameField = driver.findElement(LAST_NAME_BOX_LOCATOR);
        pageAction.typeText(lastNameField, lastName);
    }

    public void enterAddress(String address) {
        addressField = driver.findElement(ADDRESS_BOX_LOCATOR);
        pageAction.typeText(addressField, address);
    }

    public void enterCity(String city) {
        cityField = driver.findElement(CITY_BOX_LOCATOR);
        pageAction.typeText(cityField, city);
    }

    public void enterTelephone(String telephone) {
        telephoneField = driver.findElement(TELEPHONE_LOCATOR);
        pageAction.typeText(telephoneField, telephone);
    }

    public void clickAddOwnerButton() {
        addOwnerButton = driver.findElement(ADD_OWNER_BUTTON_LOCATOR);
        pageAction.clickButton(addOwnerButton);
    }

}


