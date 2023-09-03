package com.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import  java.awt.Robot;
import  java.awt.datatransfer.StringSelection;

import  java.awt.Toolkit;
import  java.awt.event.KeyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {
	
	    public static void main(String[] args) throws AWTException, InterruptedException {
	    	
			  WebDriverManager.chromedriver().setup();
			  ChromeOptions  options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
			  ChromeDriver driver = new ChromeDriver(options);
			  driver.manage().window().maximize();
			  
		//	  driver.get("https://the-internet.herokuapp.com/upload");
		//	  driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			  driver.get("https://demo.guru99.com/selenium/upload/");
			  
		//	  driver.get("https://demoqa.com/upload-download");
			  
			  
			                                                    //   use send Keys
			  
		/*	  driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\Innodeed Systems\\Documents\\face match Data\\New folder\\AFiles\\20190915_214929.jpg");
			  Thread.sleep(2000);
			  driver.findElement(By.id("terms"));
			  Thread.sleep(2000);
			  driver.findElement(By.id("submitbutton"));
			  
			  Thread.sleep(2000);*/
			  
			  
			                                                                     // using     robot class
			  
     WebElement button=   driver.findElement(By.id("uploadfile_0"));
     Actions act = new Actions(driver);
     act.moveToElement(button).click().perform();
     
       Robot rb = new Robot();
    
   	rb.delay(2000);
   	
   	//put path to file in a clipboard
   	
   	StringSelection ss = new StringSelection("C:\\Users\\Innodeed Systems\\Documents\\face match Data\\New folder\\AFiles\\20190915_214929.jpg");
   	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
   	
   	//Ctrl+v
   	
   	rb.keyPress(KeyEvent.VK_CONTROL); // press on CRTL key
   	rb.keyPress(KeyEvent.VK_V);
   	rb.delay(2000);
   	
   	rb.keyRelease(KeyEvent.VK_CONTROL);
   	rb.keyRelease(KeyEvent.VK_V);
   	rb.delay(2000);
   	
   	// Enter
   	
   	rb.keyPress(KeyEvent.VK_ENTER); // press Enter
   	rb.keyRelease(KeyEvent.VK_ENTER);
   	
   	Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@type='button']")).click();
       
       
			   

			  
		}

}
