package newpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeysMouseActions {
    
    public static void main(String[] args) {
        String baseUrl = "http://newtours.demoaut.com/";
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
                WebDriver driver = new FirefoxDriver();

                driver.get(baseUrl);
                WebElement link_Home = driver.findElement(By.linkText("Home"));
                WebElement td_Home = driver
                        .findElement(By
                        .xpath("//html/body/div"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr"));    
                 
                Actions builder = new Actions(driver);
                Action mouseOverHome = builder
                        .moveToElement(link_Home)
                        .build();
                 
                String bgColor = td_Home.getCssValue("background-color");
                System.out.println("Before hover: " + bgColor);        
                mouseOverHome.perform();
                bgColor = td_Home.getCssValue("background-color");
                System.out.println("After hover: " + bgColor);
                driver.close();
    }
    
    /** Multi-Action example ================================================== */
    //Actions builder = new Actions(driver); // Note the plural "Actions"
    
	//    Action seriesOfActions = builder
	//    		.moveToElement(txtUsername, Keys.SHIFT)
	//    		.sendKeys(txtUsername, "hello")
	//    		.keyUp(txtUsername, Keys.SHIFT)
	//    		.doubleClick(txtUsername)
	//    		.contextClick()
	//    		.build();
    
    //seriesofActions.perform();
}