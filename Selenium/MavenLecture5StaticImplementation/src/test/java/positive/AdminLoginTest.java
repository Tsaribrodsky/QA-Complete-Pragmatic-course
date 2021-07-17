package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import utilities.Browser;
import utilities.verifcators.CommonVerifications;

/**
 * <h1>AdminLoginTest</h1>
 * Class for positive admin login test.
 */
public class AdminLoginTest {

	/**
	 * Method which opens a browser of your choice.
	 */
	@Before
	public void setup() {
		Browser.open("chrome");
	}

	/**
	 * Method which test successful admin login.
	 */
	@Test
	public void successfulLogin() {
		AdminLogin.open();
		AdminLogin.login("admin", "parola123!");
		
		CommonVerifications.verifyTitle("Dashboard",
				"The title was not present, so we are NOT logged in. BUUUG! ");
	}

	/**
	 * Method which close browser.
	 */
	@After
	public void tearDown() {
		Browser.quit();
	}
}
