package positive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.admin.AdminLogin;
import pages.admin.HomeDashboardDevSettings;
import utilities.Browser;

/**
 * <h1>ClearThemeCacheTest</h1>
 * Class for successful test clear theme cache.
 * @author Dani Tsaribrodski
 * @version 1.0
 */
public class ClearThemeCacheTest {

    /**
     * Method which opens a browser of your choice.
     */
    @Before
    public void setup() {
        Browser.open("chrome");
    }

    /**
     * Method which test cleared theme cache from Developer Settings. But first open admin login form and successful log in.
     */
    @Test
    public void ClearThemeCache() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");

        HomeDashboardDevSettings.openDeveloperSettings();
        HomeDashboardDevSettings.ThemeRefresh();
    }

    /**
     * Method which close browser.
     */
    @After
    public void tearDown() {
        Browser.quit();
    }
}
