package com.Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utlityFile;

public class FileScreenshot {

	WebDriver driver;
	WebDriverWait wait;
	WebElement dashboard;
	

	@BeforeTest
	public void setup() {
		
	

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));


	}

	@Test
	public void verfiy() throws InterruptedException {
		
	   //	driver.get("https://en.wikipedia.org/wiki/Hello_(Adele_song)");
      //	 driver.get("https://github.com/login");
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  
	                                                                                       // Hello website

	/*	String Actualtitle = driver.getTitle();
		String ExpectedTitle = "Hello (Adele song) - Wikipediaa";
		Assert.assertEquals(Actualtitle, ExpectedTitle, "Title is mismatched");*/
	  
	  
	                                                                               // Github login
	
   /*  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).sendKeys("arunbabu120894@gmail.com");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Arungit1862");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='commit']"))).click();
    
    
       String Actualresult= driver.getTitle();
       String ExpectedResult= "GitHub";
       Assert.assertEquals(Actualresult, ExpectedResult,"login not successfully");
           System.out.println("login successfully");
           Thread.sleep(2000);*/
                                                                                               // Orange hrm
	     Thread.sleep(2000);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
           Thread.sleep(500);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
           Thread.sleep(500);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
           Thread.sleep(2000);
           
           Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Paul Collings']")).isDisplayed(),"login not succesfully");  
           
     //      WebElement  username= driver.findElement(By.xpath("//p[text()='Paul Collings']"));
     //      Assert.assertTrue(username.isDisplayed(),"login not succesfully");  
     //      Assert.assertTrue(username.getText().startsWith("P"),"login not successfully");
              System.out.println("login successfully");
             Thread.sleep(5000);
               
   

	}

	@org.testng.annotations.AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + "   FailedTestCaseImage.png";

		if (ITestResult.FAILURE == result.getStatus()) 
		{

			utlityFile.TakeScreenshot(driver, result.getName() + FileName);

		}

	}

	@AfterTest
	public void TearDown() {

		driver.quit();

	}

}
