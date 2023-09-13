package com.Files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotwebElement {
	
	@Test
	public void logo() throws IOException {
		
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions  options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		  ChromeDriver driver = new ChromeDriver(options);
		  driver.manage().window().maximize();
		  driver.get("https://en.wikipedia.org/wiki/Hello_(Adele_song)");
	     
		  
    	  WebElement logo=	  driver.findElement(By.xpath("//img[@class='mw-logo-icon']"));
	
	    Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + "  logo.png";	  
		File src=  logo.getScreenshotAs(OutputType.FILE);
		File des= new File("./screenshot/"+ FileName );
		FileUtils.copyFile(src, des);
		System.out.println("screenshot saved sucessfully");
		driver.quit();
		  
	}
	@Test
	public void fullPage() throws IOException, InterruptedException {
		
		    WebDriverManager.chromedriver().setup();
		    ChromeOptions  options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		     ChromeDriver driver = new ChromeDriver(options);
		     driver.manage().window().maximize();
	         driver.get("https://www.selenium.dev/");
	        	   
	    	    JavascriptExecutor 		jse3 = (JavascriptExecutor) driver; 
	    	    int a=1;
	    	     int i = 1;
	   	    	int x = 0;
	   	     	int y = 50;
	   		   while (i < 8)
	   		   {
	   			
	   	    	 TakesScreenshot ts = (TakesScreenshot) driver;
			    File src= ts.getScreenshotAs(OutputType.FILE);
			      File  dest= new File("./screenshot/img251"+a+".jpg");
		       FileUtils.copyFile(src, dest);
		       System.out.println("screenshot succesfully");
		       a++;

	   			jse3.executeScript("window.scrollBy(" + x + "," + y + ");");
	   			Thread.sleep(2000);
	   			i++;
	   			x = x + 10;
	   			y = y + 100;
	   		}   
	   		   driver.quit();
	}
	   		   
	   		@Test
	   		public void sectionOfthePage() throws IOException, InterruptedException {
	   			
	   			  WebDriverManager.chromedriver().setup();
	   			  ChromeOptions  options2 = new ChromeOptions();
	   				options2.addArguments("--remote-allow-origins=*");
	   			  ChromeDriver driver = new ChromeDriver(options2);
	   			  driver.manage().window().maximize();
	   		      driver.get("https://www.cricbuzz.com/cricket-match/live-scores");
	   		      
           //      	 WebElement   section =   driver.findElement(By.xpath("(//div[@class='cb-mtch-lst cb-col cb-col-100 cb-tms-itm'])[1]"));
                	 WebElement   section =   driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-rank-tabs']"));
                 	
	                 File src   =  section.getScreenshotAs(OutputType.FILE);   	    
	   				 File  dest= new File("./screenshot/section.jpg");
	   			     FileUtils.copyFile(src, dest);
	   			     System.out.println("screenshot succesfully");
	   			     Thread.sleep(1000);
	   		   		 driver.quit();
	    
		}
	   		
	   		@Test
	   		public void elementOfthePage() throws IOException, InterruptedException {
	   			
	   			  WebDriverManager.chromedriver().setup();
	   			  ChromeOptions  options2 = new ChromeOptions();
	   			  options2.addArguments("--remote-allow-origins=*");
	   			  ChromeDriver driver = new ChromeDriver(options2);
	   			  driver.manage().window().maximize();
	   		      driver.get("https://www.selenium.dev/");
                 WebElement   elementTitle=     driver.findElement(By.xpath("//div[@class='d-flex justify-content-center td-box--100 pt-5']//h2"));
                 	
         
	                  File src   =  elementTitle.getScreenshotAs(OutputType.FILE);   
	   				  File  dest= new File("./screenshot/Element.jpg");
	   			      FileUtils.copyFile(src, dest);
	   			      System.out.println("screenshot succesfully");
	   			       Thread.sleep(1000);
	   		   		   driver.quit();
	    
		}
	       
	         
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//@Test
	public void date(String date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	     Date date1 = new Date();
//	      String dateTime  =String.valueOf(date1);
	     String date2   =    formatter.format(date1);
	     System.out.println("ExcutionTime :"+ formatter.format(date1));
	}
	
	
	

}
