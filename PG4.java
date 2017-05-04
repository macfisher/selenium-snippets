package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PG4 {
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Actions")).click();
        
        String alertMessage = "";
        
        driver.get("http://jsbin.com/usidix/1");
        
        driver.findElement(By.cssSelector("input[value='Go!']")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        
        System.out.println(alertMessage);
        driver.quit();
	}
}
