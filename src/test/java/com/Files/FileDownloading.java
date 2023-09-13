package com.Files;

import java.io.File;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utlityFile;

public class FileDownloading {
	
public static 	WebDriverWait wait;
WebDriver driver;
 String expectedfile="chromedriver_win32.zip";
 String location="C:\\Users\\Innodeed Systems\\Documents\\DownloadfromAuto";


@Parameters("browser")
@BeforeTest
public void intialize( @Optional("chrome")   String browser) {
	
	switch (browser.toLowerCase()) {
	case "chrome":
		
		HashMap<String,Object> preferences1 = new HashMap<>();
    	 preferences1.put("download.default_directory", location);
   	 
   	    ChromeOptions options1 = new ChromeOptions();
    	options1.setExperimentalOption("prefs", preferences1);	
     	 options1.addArguments("Start-maximized");
   	    options1.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
   		options1.addArguments("--remote-allow-origins=*");
   	 
   	     WebDriverManager.chromedriver().setup();
       driver  = new ChromeDriver(options1);
		
		break;
		
     	case "edge":
		
		 HashMap preferences2 = new HashMap();
    	 preferences2.put("download.default_directory", location);
    	 
    	 EdgeOptions options = new EdgeOptions();
    	 options.setExperimentalOption("prefs", preferences2);	
   	   options.addArguments("Start-maximized");
	   options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));	
    	options.addArguments("--remote-allow-origins=*");
    	 
    	 WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
         break;
         
     	case "firefox":
    		
     		FirefoxProfile profile= new FirefoxProfile();
            profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.download.dir", location);
            
            
         	 FirefoxOptions options3 = new FirefoxOptions();
         	 options3.setProfile(profile);
         	 
         	 WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options3);
            break;

	default:
		
		System.err.println("browser is invalid");
		break;
	}
}


@Parameters({"url", "ThreadSleep"})
@Test
 public void fileDownload(String url ,long threadSleep) throws InterruptedException {
	utlityFile uff= new utlityFile();

          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get(url);
         Thread.sleep(threadSleep);
          
          WebElement download=      driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")) ;
         Actions action = new Actions(driver);
         action.moveToElement(download).click().perform();
         uff.waitForFileDownload(driver, location, expectedfile);
       
  
     }
@Parameters("ThreadSleep")
@AfterTest
public void TearDown(long  threadSleep ) throws InterruptedException {
	
    //    Thread.sleep(threadSleep);
        
       driver.quit();
}

}
