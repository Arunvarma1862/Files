package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utlityFile {
	
	public static void TakeScreenshot(WebDriver driver, String ScreenShotName) throws IOException {
		
		TakesScreenshot takescreenshot= (TakesScreenshot) driver;
		File sourcefile =takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new  File("./screenshot/"+ScreenShotName+" .png");
		FileUtils.copyFile(sourcefile, destfile);
		System.out.println("screenshot saved succesfully");
	}
	
	public static void waits(WebDriver driver) {
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	   public  void waitForFileDownload(WebDriver driver, String downloadPath, String fileName)
	    {
	        // Wait for a maximum of 60 seconds for the file to download
	        for (int i = 0; i < 60; i++) 
	        {
	            try {
	                // Check if the file exists in the download folder
	                File file = new File(downloadPath + File.separator + fileName);
	                if (file.exists())
	                {
	                    System.out.println("File download completed.");
	                    return;
	                }
	            }
	            catch (Exception e)
	            {
	                // Handle exceptions as needed
	            }
	            
	            // Sleep for 1 second before checking again
	            try
	            {
	                Thread.sleep(1000);
	            } 
	            catch (InterruptedException e)
	            {
	                // Handle interruptions
	            }
	        }
	        
	        // If the file is not downloaded after waiting for 60 seconds, you can raise an error or handle it accordingly
	        System.out.println("File download did not complete within the expected time.");
	    }



}
