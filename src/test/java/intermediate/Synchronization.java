package intermediate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Synchronization {

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		driver = new ChromeDriver();
		
		//configure timeout
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

		// Enter URL
		driver.get("https://www.test-how.com/");
		
		
	}
	
	@Test
	public static void dropdown() {
	
		//click on demo apps dropdown	
		driver.findElement(By.linkText("Demo Apps")).click();
		//click on TH frames option
		driver.findElement(By.linkText("TH Store")).click();
		
		//assume that you clicked on forgot password
		
		//it takes 10sec to load
		
		//wait for the alert
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert();
		System.out.println("I have waited till alert is present");
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
