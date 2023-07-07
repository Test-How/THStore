package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateCommands {
	

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		driver = new ChromeDriver();

		// Enter URL
		driver.get("https://www.test-how.com/demo/thstore/v1/signup");
	}
	
	@Test
	public static void navigateCommands() {
		//navigate to url
		driver.navigate().to("https://outlook.com");
		
		//navigate back
		driver.navigate().back();
		
		//navigate forward
		driver.navigate().forward();
		
		//refresh the page
		driver.navigate().refresh();
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}


}
