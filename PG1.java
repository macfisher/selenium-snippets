package newpackage;

// Importing wild card packages for now
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class PG1 {
	public static void main(String[] args) {
		// Declaration and instantiation of objects/variables
		WebDriver driver;
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseUrl = "http://newtours.demoaut.com";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		// Launch Firefox and direct it to the Base URL
		driver.get(baseUrl);
		
		// Get the actual value of the title
		actualTitle = driver.getTitle();
		
		/**
		 * Compare the actual title of the page with the expected one
		 * and print the result as "Passed" or "Failed".
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		
		// Close Firefox
		driver.close();
		
		// Exit the program explicitly
		System.exit(0);
	}
}
