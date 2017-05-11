package archive;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.security.UserAndPassword;

public class ApacheLogin {
	public static void main(String[] args) {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
        String baseUrl = "http://staging.test.com/";
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        
        // TRY 4
        Alert alert = driver.switchTo().alert() ;
        alert.authenticateUsing(new UserAndPassword("username", "password"));
        driver.switchTo().defaultContent();
        
        // TRY 1
        //driver.get("http://UserName:staging@test.com"); // TRY THIS ONE AGAIN
        
        // TRY 2
        /*WebDriverWait wait10 = new WebDriverWait(driver, 10);
        Alert alert = wait10.until(ExpectedConditions.alertIsPresent());     
        alert.authenticateUsing(new UserAndPassword("username", "password"));*/
        
        
        
        //driver.quit();
    }
}
