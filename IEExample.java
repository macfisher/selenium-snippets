package newpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.ui.*;

public class IEExample {
	/**
	,---------------------.
	| IE Browser Settings |
	|-----------------------------------------------------------------------------------------------.
	|                                                                                               |
	| It needs to set same Security level in all zones:                                             |
	|                                                                                               |
	| 1.Open IE                                                                                     |
	| 2.Go to Tools -> Internet Options -> Security                                                 |
	| 3.Set all zones (Internet, Local intranet, Trusted sites, Restricted sites)                   |
	|   to the same protected mode, enabled or disabled should not matter.                          |
	|                                                                                               |  
	| Finally, set Zoom level to 100% by right clicking on the gear located at the top right corner | 
	| and enabling the status-bar. Default zoom level is now displayed at the lower right.          |
	|                                                                                               |
	| NOTE: Running on IE11 on Windows 7. Edge only runs on Windows 10.                             |
	|                                                                                               |
	`-----------------------------------------------------------------------------------------------'
	 */
	
	
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
