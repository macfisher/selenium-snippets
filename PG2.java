package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

// May need these imports later
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.NoSuchElementException;


public class PG2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String baseUrl  	= "https://www.facebook.com";
		String email    	= "email@gmail.com";
		String password 	= "password";
		
		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		// Enter email address
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement emailElem = driver.findElement(By.id("email"));
		emailElem.sendKeys(email);
		
		// Enter password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
		WebElement passwordElem = driver.findElement(By.cssSelector("#pass"));
		passwordElem.sendKeys(password);
		
		// Login
		String loginSel = "input[data-testid='royal_login_button']";
		WebElement loginBtn = driver.findElement(By.cssSelector(loginSel));
		loginBtn.click();
		
		boolean loginErrorExists = driver.findElements(By.cssSelector("._4rbf")).size() != 0;
		
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		if (loginErrorExists) {
			String loginErrorText = driver.findElement(By.cssSelector("._4rbf")).getText();
			String loginErrorExpectedText = "The password you’ve entered is incorrect. Forgot Password?";
			
			System.out.println(loginErrorText);
			Assert.assertEquals(loginErrorExpectedText, loginErrorText);
			Assert.fail("Login failed");
		} else {
			String profileIconSelStr = "div[data-click='profile_icon']";
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(profileIconSelStr)));
			System.out.println("Login success");
		}
				
		driver.close();
		System.exit(0);
	}
}