import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest extends BaseTest{
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @After
    public void afterClass() {
        quitBrowser();
    }

    @Test
    public void cantLoginWithInvalidEmailAndPassword() {
        loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("alex@pragmatic.bg");
        loginPage.enterPassword("12345126");
        loginPage.clickLoginButton();
        Assert.assertEquals("", "Грешно потребителско име или парола. Моля, опитайте отново.", loginPage.getBadLoginErrorMessage());
    }

    @Test
    public void cantLoginWithBlankEmailAndPassword() {
        loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals("", "Моля, попълнете вашия email", loginPage.getBadLoginErrorMessage());
    }

    @Test
    public void canLoginWithValidCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.enterEmail("karamfilovs@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.getUserPanelText().equals("karamfilovs@gmail.com"));
    }

}
