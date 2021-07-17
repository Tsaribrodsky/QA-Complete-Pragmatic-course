package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * <h1>Browser</h1>
 * Browser class represents which kind of browser will be open in test.
 */
public class Browser {
	
	public static WebDriver driver;

	/**
	 * A method which is used for opening a certain browser
	 * 
	 * Example usage: open("chrome"), open("firefox"), open("ie")
	 * 
	 * @param browser based on the provided parameter a browser will be opened
	 */
	public static void open(String browser) {
		switch (browser) {
			case "chrome": {
				System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
				
			}
			
			case "firefox": {
				System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;

			}
			
			case "ie": {
				System.setProperty("webdriver.ie.driver", "D:\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;
				
			}

		default: throw new RuntimeException("There is no such browser, take a look at the method javadoc examples");
		}
	}

	/**
	 * Quits the current process of the opened browser
	 */
	public static void quit() {
		driver.quit();
	}

}
