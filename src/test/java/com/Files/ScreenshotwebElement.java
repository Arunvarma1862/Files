package com.Files;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotwebElement {
	
	@Test
	public void webelementScreenshot() throws IOException {
		
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
	
	//@Test
	public void date(String date) {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	     Date date1 = new Date();
//	      String dateTime  =String.valueOf(date1);
	     String date2   =    formatter.format(date1);
	     System.out.println("ExcutionTime :"+ formatter.format(date1));
	}
	
	
	

}
