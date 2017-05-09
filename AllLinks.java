package archive;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AllLinks {
	public static void main(String[] args) {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver(capabilities);
		
        String baseUrl = "http://newtours.demoaut.com/";
        String underConsTitle = "Under Construction: Mercury Tours";
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        
        String[] linkTexts = new String[linkElements.size()];
        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

        //test each link
        for (String t : linkTexts) {
            driver.findElement(By.linkText(t)).click();
            if (driver.getTitle().equals(underConsTitle)) {
                System.out.println("\"" + t + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + t + "\""
                        + " is working.");
            }
            //driver.navigate().back(); --> fails to work /w IEDriverServer.exe
            driver.get(baseUrl);
        }
        driver.quit();
    }
}
