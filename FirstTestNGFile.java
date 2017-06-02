package archive;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class FirstTestNGFile {
	public String baseUrl = "http://newtours.demoaut.com/";
	String driverPath = "C:\\Selenium\\IEDriverServer.exe";
	public WebDriver driver;
	
	@Test(priority = 1)
	public void setupDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		
		System.out.println("launching ie11 browser");
		System.setProperty("webdriver.ie.driver", driverPath);
		driver = new InternetExplorerDriver(capabilities);
	}
	
	@Test(priority = 2)
	public void verifyHomepageTitle() {
		driver.get(baseUrl);
		
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		//driver.close();
	}
	
	@Test(priority = 3)
	public void faceBookTest() {
		String baseUrl  	= "https://www.facebook.com";
		String email    	= "email@gmail.com";
		String password 	= "password";
		
		driver.get(baseUrl);

		WebDriverWait wait3 = new WebDriverWait(driver, 3);
		
		// Enter email address
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement emailElem = driver.findElement(By.id("email"));
		emailElem.sendKeys(email);
		
		// Enter password
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
		WebElement passwordElem = driver.findElement(By.cssSelector("#pass"));
		passwordElem.sendKeys(password);
		
		// Login
		String loginSel = "input[data-testid='royal_login_button']";
		WebElement loginBtn = driver.findElement(By.cssSelector(loginSel));
		loginBtn.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String  profileIcon  = "div[data-click='profile_icon']";
		boolean loginSuccess = driver.findElements(By.cssSelector(profileIcon)).size() != 0;
		
		if (loginSuccess) {
			System.out.println("Login success");
		} else {
			WebDriverWait wait20 = new WebDriverWait(driver, 20);
			
			wait20.until(
					ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector("._4rbf"))
			);
			
			WebElement loginError             	= driver.findElement(By.cssSelector("._4rbf"));
			String     loginErrorText         	= loginError.getText();
			
			String loginErrorExpectedText = "The password you’ve entered is incorrect. Forgot Password?";
			
			System.out.println(loginErrorText);
			Assert.assertEquals(loginErrorExpectedText, loginErrorText);
			Assert.fail("Login failed");
		}
				
		driver.close();
		System.exit(0);
	}
  
}
