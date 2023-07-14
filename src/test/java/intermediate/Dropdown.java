package intermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

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
	public static void dropdown() {
	
		//create a web element for your dropdown
		WebElement membershipDrpdn=driver.findElement(By.name("user_job"));
		//create Select class instance to that webelement
		Select membership= new Select(membershipDrpdn);
		//use either selectByIndex
		membership.selectByIndex(0);
		//SelectByValue
		membership.selectByValue("basic");
		//SelectByVisibleText
		membership.selectByVisibleText("Prime");
		
		//how to check which option is selected
		String myOption=membership.getFirstSelectedOption().getText();
		
		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
