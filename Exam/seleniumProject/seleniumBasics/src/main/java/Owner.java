import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Owner extends BasePage{


    private static final By FIRST_NAME_BOX_LOCATOR = By.id("firstName");
    private static final By LAST_NAME_BOX_LOCATOR = By.id("lastName");
    private static final By ADDRESS_BOX_LOCATOR = By.id("address");
    private static final By CITY_BOX_LOCATOR = By.id("city");
    private static final By TELEPHONE_LOCATOR = By.id("telephone");
    private static final By ADD_OWNER_BUTTON_LOCATOR = By.xpath("//button[text()='Add Owner']");
    private static final By ADD_OWNER_LINK_LOCATOR = By.xpath("//a[text()='Add Owner']");
    private static final String PAGE_URL = "owners/find.html";
    private static final By FIRST_NAME_NOT_EMPTY_LOCATOR = By.cssSelector("input#firstName+span");
    private static final By LAST_NAME_NOT_EMPTY_LOCATOR = By.cssSelector("input#lastName+span");
    private static final By ADDRESS_BOX_NOT_EMPTY_LOCATOR = By.cssSelector("input#address+span");
    private static final By CITY_BOX_NOT_EMPTY_LOCATOR = By.cssSelector("input#city+span");
    private static final By TELEPHONE_NOT_EMPTY_LOCATOR = By.cssSelector("input#telephone+span");

    private WebElement addOwner;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement addressField;
    private WebElement cityField;
    private WebElement telephoneField;
    private WebElement addOwnerButton;
    private WebElement firstNameNotEmptyMessage;
    private WebElement lastNameNotEmptyMessage;
    private WebElement addressNotEmptyMessage;
    private WebElement cityNotEmptyMessage;
    private WebElement telephoneNotEmptyMessage;

    public Owner(WebDriver driver){
        super(driver);
    }

    public void gotoPage() {
        pageAction.navigateTo(BASE_URL, PAGE_URL);
    }

    public void clickAddOwnerLink() {
        addOwner = driver.findElement(ADD_OWNER_LINK_LOCATOR);
        pageAction.clickButton(addOwner);
    }

    public void enterFirstName(String firstName) {
        firstNameField = driver.findElement(FIRST_NAME_BOX_LOCATOR);
        pageAction.typeText(firstNameField, firstName);
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

    public String messageFirstNameNotEmpty() {
        firstNameNotEmptyMessage = driver.findElement(FIRST_NAME_NOT_EMPTY_LOCATOR);
        return pageAction.getText(firstNameNotEmptyMessage);
    }

    public String messageLastNameNotEmpty() {
        lastNameNotEmptyMessage = driver.findElement(LAST_NAME_NOT_EMPTY_LOCATOR);
        return pageAction.getText(lastNameNotEmptyMessage);
    }

    public String messageAddressNotEmpty() {
        addressNotEmptyMessage = driver.findElement(ADDRESS_BOX_NOT_EMPTY_LOCATOR);
        return pageAction.getText(addressNotEmptyMessage);
    }

    public String messageCityNotEmpty() {
        cityNotEmptyMessage = driver.findElement(CITY_BOX_NOT_EMPTY_LOCATOR);
        return pageAction.getText(cityNotEmptyMessage);
    }

    public String messageTelephoneNotEmpty() {
        telephoneNotEmptyMessage = driver.findElement(TELEPHONE_NOT_EMPTY_LOCATOR);
        return pageAction.getText(telephoneNotEmptyMessage);
    }
}
