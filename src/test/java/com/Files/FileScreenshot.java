package com.Files;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.utlityFile;

public class FileScreenshot {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
//		driver.get("https://www.mayoclinic.org");
	//	driver.get("https://www.headspace.com/login");
		driver.get("https://en.wikipedia.org/wiki/Hello_(Adele_song)");

	}

	@Test
	public void verfiy() {

		String Actualtitle = driver.getTitle();
		String ExpectedTitle = "Hello (Adele song) - Wikipediaa";
		Assert.assertEquals(Actualtitle, ExpectedTitle);
	//	driver.findElement(By.id("emails")).sendKeys("HelloBye@gmail.com");

	}

	@org.testng.annotations.AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			utlityFile.TakeScreenshot(driver, result.getName());

		}

	}

	@AfterTest
	public void TearDown() {

		driver.quit();

	}

}
