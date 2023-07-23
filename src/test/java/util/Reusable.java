package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusable {

	public static void calculatePrincipleInterset() {

	}

	public static void getWindowSize() {

	}

	public static void getRandomString() {

	}

	public static void getCurrentWindowScreenshot(WebDriver driver, String screenshotPath) throws Exception {

		// implement code to take screenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(screenshotPath);
		try {
			// Copy file at destination

			FileUtils.copyFile(SrcFile, DestFile);
			
		}catch(IOException e) {
			System.out.println("Your destination path might be wrong, please check");
			System.out.println(" complete error log "+ e);
		}catch(Exception e) {
			System.out.println("Some exception occurred, please check");
			throw(e);
		}finally {
			System.out.println("file copy function is completed.");
			System.out.println("I have taken the screenshot");
		}



	}

	public static int sumAllProducts() {
		return 1000;
	}
	
	
}
