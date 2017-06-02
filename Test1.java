package archive;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.*;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.*;


public class Test1 extends TestBase 
{
	@Test
	public void testMethod() {
		System.out.println("I am in testMethod 1");
		driver.get("www.google.com");
		
		// Driver from TestBase is accessible here
		// Your assertions come here.
	}
	
	@Test
	public void testMethod2() {
		System.out.println("I am in testMethod 2");
		driver.get("www.facebook.com");
	}
}