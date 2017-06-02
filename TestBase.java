package archive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class TestBase {
	//protected WebDriver driver;
	public static WebDriver driver; // Needs to be public static!
	
	
	@BeforeTest(alwaysRun = true)
	public void setUp() {
		System.out.println("I am in setUp method.");
		
		String driver_path = "C:\\Selenium\\IEDriverServer.exe";
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		
		System.out.println("launching ie11 browser");
		
		System.setProperty("webdriver.ie.driver", driver_path);
		driver = new InternetExplorerDriver(capabilities);
		// consider an implicit wait ~10 seconds after instantiation
		
		// Execute login() function
	}
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		System.out.println("I am in tearDown method."); // requires alwaysRun!
		driver.close();
		//System.exit(0);
	}
}
