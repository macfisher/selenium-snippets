package archive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SetupDriver {
	String driverPath = "C:\\Selenium\\IEDriverServer.exe";
	public WebDriver driver;
	
	  @Test
	  public void setupDriver() {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			
			System.out.println("launching ie11 browser");
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver(capabilities);
		}
}
