package com.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {
	
	WebDriver driver;
	@BeforeTest
	public void intialize() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		// driver.get("https://the-internet.herokuapp.com/upload");
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		// driver.get("https://demoqa.com/upload-download");
		
	//	driver.get("https://demo.guru99.com/selenium/upload/");
		
	}

	
	@Test
	public void FileUploadbysendkeys() throws AWTException, InterruptedException {

		

		                                                                                                // use send Keys

		
		/*  driver.findElement(By.id("uploadfile_0")).
		 sendKeys("C:\\Users\\Innodeed Systems\\Documents\\face match Data\\New folder\\AFiles\\20190915_214929.jpg" ); 
		  Thread.sleep(1000);
		  driver.findElement(By.id("terms")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("submitbutton")).click();*/
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Innodeed Systems\\Documents\\face match Data\\Mutipleselfies sprinit\\20190915_214929.jpg");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[text()='Start upload']")).click();
		  Thread.sleep(1000);
		
		  
	
	}
	@Test(dataProvider = "fileData")
	public void FileUploadbyRobotclass(String data) throws AWTException, InterruptedException {

		                                                                                                   // using robot class

	   WebElement button = driver.findElement(By.xpath("//input[@type='file']"));
		Actions act = new Actions(driver);
		act.moveToElement(button).click().perform();

		Robot rb = new Robot();

		rb.delay(2000);

		StringSelection ss = new StringSelection(
			data);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);



		rb.keyPress(KeyEvent.VK_ENTER); 
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[text()='Start upload']")).click();
		  Thread.sleep(1000);

	/*	Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();*/
		
		
		

	}
	@AfterTest
	public void teardown() throws InterruptedException {
		
		Thread.sleep(10000);
		driver.quit();
		
	}
	
	@DataProvider(name="fileData")
	public Object[] FileData() {
		
		Object data[]= new Object[3];
		
		data[0]="C:\\Users\\Innodeed Systems\\Documents\\face match Data\\Mutipleselfies sprinit\\20190915_214929.jpg";
		data[1]="C:\\Users\\Innodeed Systems\\Documents\\face match Data\\SpoofSelfie\\2023-02-02 09_50_46.771421SELFIE_IMAGE.jpg";
		data[2]="C:\\Users\\Innodeed Systems\\Documents\\face match Data\\6Gb\\2023-02-03 05_00_53.612627SELFIE_IMAGE.jpg";
		
	
		return data;
	}

}
