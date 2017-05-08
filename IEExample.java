package newpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
		
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		String search_query = "test query";
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib")));
		WebElement search = driver.findElement(By.id("lst-ib"));
		search.sendKeys(search_query);
	}
}