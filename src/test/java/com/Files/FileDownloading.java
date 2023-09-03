package com.Files;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloading {
	
public static 	WebDriverWait wait;
	
 public static void main(String[] args) throws InterruptedException {
    	 
    	 
    	 String location="C:\\Users\\Innodeed Systems\\Documents\\DownloadfromAuto";
    	 
    	 
    	                                               //chrome
    	 
    	/* HashMap<String,Object> preferences = new HashMap<>();
    	 preferences.put("download.default_directory", location);
    	 
    	 ChromeOptions options = new ChromeOptions();
    	 options.setExperimentalOption("prefs", preferences);	
      	  options.addArguments("Start-maximized");
    	  options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
    		options.addArguments("--remote-allow-origins=*");
    	 
    	 WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver(options);
         
         wait  = new WebDriverWait(driver, Duration.ofSeconds(15));*/
         
         
                                                                                        //Edge
         
        HashMap preferences = new HashMap();
    	 preferences.put("download.default_directory", location);
    	 
    	 EdgeOptions options = new EdgeOptions();
    	 options.setExperimentalOption("prefs", preferences);	
   	  options.addArguments("Start-maximized");
	  options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));	
    		options.addArguments("--remote-allow-origins=*");
    	 
    	 WebDriverManager.edgedriver().setup();
         WebDriver driver = new EdgeDriver(options);
         
         
         
    	                                                                              // firefox
    	 
    /*  FirefoxProfile profile= new FirefoxProfile();
       profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
       profile.setPreference("browser.download.folderList", 2);
       profile.setPreference("browser.download.dir", location);
       
       
    	 FirefoxOptions options = new FirefoxOptions();
    	 options.setProfile(profile);
    	 
    	 WebDriverManager.firefoxdriver().setup();
         WebDriver driver = new FirefoxDriver(options);*/
         
         
         
            
    	 
    	 
       
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");
         Thread.sleep(2000);
          
         WebElement download=      driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")) ;
       Actions action = new Actions(driver);
       action.moveToElement(download).click().perform();
           
         
          
          
          
          
    //      Thread.sleep(3000);
    //      driver.quit();
    	 
     
     }

}
