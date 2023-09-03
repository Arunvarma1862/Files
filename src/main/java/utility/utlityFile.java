package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utlityFile {
	
	public static void TakeScreenshot(WebDriver driver, String ScreenShotName) throws IOException {
		TakesScreenshot takescreenshot= (TakesScreenshot) driver;
		File sourcefile =takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new  File("./screenshot/"+ScreenShotName+" .png");
		FileUtils.copyFile(sourcefile, destfile);
		System.out.println("screenshot saved succesfully");
	}

}
