package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverCommands {

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
	public static void driverCommands() {
		
		//get current url
		String currentURL= driver.getCurrentUrl();
		System.out.println("Current url is : "+ currentURL);
		
		//get page title
		String pageTitle= driver.getTitle();
		System.out.println("Title is : "+pageTitle);
		
		//get page source
		String pageSourceCode= driver.getPageSource();
		System.out.println(pageSourceCode);
		
		//find element
		WebElement inputField=driver.findElement(By.tagName("label"));
		System.out.println("First input field label is : "+inputField.getText());
		
		//find elements
		List<WebElement> inputs=driver.findElements(By.tagName("label"));
		System.out.println("All the inputfields labeles");
		for(WebElement input:inputs) {
			System.out.println(input.getText());
		}
		
		//launching multiple tabs
		driver.switchTo().newWindow(WindowType.TAB);	
		driver.get("https://google.com");
		
		driver.switchTo().newWindow(WindowType.TAB);	
		driver.get("https://outlook.com");
		
		//close current focused browser
		driver.close();
		
		//close all browsers and cleanup driver process
		driver.quit();
		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}


}
