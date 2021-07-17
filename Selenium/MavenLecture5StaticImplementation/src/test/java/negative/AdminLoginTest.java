package negative;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import utilities.Browser;

/**
 * <h1>AdminLoginTest</h1>
 * Class for negative admin login test.
 */

public class AdminLoginTest {

	/**
	 * A method which opens a browser of your choice.
	 */
	@Before
	public void setup() {
		Browser.open("chrome");
	}

	/**
	 * A method which test unsuccessful admin login.
	 */
	@Test
	public void unsuccessfulLogin() {
		AdminLogin.open();
		AdminLogin.login("fdasfdas", "dsfasfd");
		
		AdminLogin.verifyLoginFormValidationMessage("No match for Username and/or Password.",
				"The expected validation message for wrong credentials was not present, BUUUUUG");
	}

//	/**
//	 * A method which close browser.
//	 */
//	@After
//	public void tearDown() {
//		Browser.quit();
//	}
}
