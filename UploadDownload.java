package archive;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// https://eternallybored.org/misc/wget/ (wget64.exe)

// Test via http://www.azurespeed.com/Azure/UploadLargeFile
// wget64.exe -P C: --no-check-certificate http://azspdcentralus.blob.core.windows.net/private/100MB.bin
// c:\Wget>wget64.exe -P C: --no-check-certificate http://demo.guru99.com/selenium/yahoo.html

public class UploadDownload {
    public static void main(String[] args) {
    	/** Test Upload ======================================================= */
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        String baseUrl = "http://www.azurespeed.com/Azure/UploadLargeFile";
        WebDriver driver = new FirefoxDriver();

        driver.get(baseUrl);
        driver.findElement(By.cssSelector("a[data-target='#upload-modal']")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 3);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-input")));
        
        WebElement uploadElement = driver.findElement(By.id("file-input"));
        
        uploadElement.sendKeys("TEST");

        // enter the file path onto the file-selection input field
        // C:\\Users\\Mac\\Downloads\\desktop.ini
        //uploadElement.sendKeys("C:\\Users\\Mac\\Downloads\\desktop.ini");

       
        
        /** Test Download ===================================================== */
//        baseUrl = "http://demo.guru99.com/selenium/yahoo.html";
//        
//        driver.get(baseUrl);
//        
//        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
//        String sourceLocation = downloadButton.getAttribute("href");
//        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;
//
//        try {
//        	Process exec = Runtime.getRuntime().exec(wget_command);
//        	int exitVal = exec.waitFor();
//        	System.out.println("Exit value: " + exitVal);
//        } catch (InterruptedException | IOException ex) {
//        	System.out.println(ex.toString());
//        }
//        driver.close();
    }
}