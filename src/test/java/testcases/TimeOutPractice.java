package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeOutPractice {
	

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		driver = new ChromeDriver();

	
		
		//configure timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

		// Enter URL
		driver.get("https://www.test-how.com/demo/thstore/v1/signup");
		
	}
	
	@Test
	public static void timeOutTests() {
	
		driver.findElement(By.id("email")).sendKeys("newUser@gmail.com");
		driver.findElement(By.id("name")).sendKeys("venkatesureddy");
		driver.findElement(By.id("password")).sendKeys("welcome1234");
		driver.findElement(By.id("retypePassword")).sendKeys("welcome1234");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.partialLinkText("Don't have an account?")).click();
		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}


}
