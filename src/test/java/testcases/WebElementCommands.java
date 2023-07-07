package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommands {
	

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
	public static void webElementCommands() {
		
		//click
		driver.findElement(By.id("email")).click();
		
		//enter text
		driver.findElement(By.id("email")).sendKeys("gvreddy1265@gmail.com");
		
		//clear the text field
		driver.findElement(By.id("email")).clear();
		
		//submit form
		driver.findElement(By.id("submit")).submit();
		
		//get text of element
		String header=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(header, "Sign up");
		
		//get attribute value
		String className= driver.findElement(By.id("email")).getAttribute("class");
		System.out.println("Class name of email field is "+className);
		
		//get tag name
		String tagName= driver.findElement(By.id("email")).getTagName();
		System.out.println("Tag name of email field is "+tagName);
		
		//get css value
		String width=driver.findElement(By.xpath("//div[contains(@class, 'Avatar')]")).getCssValue("width");
		Assert.assertEquals(width, "40px");
		
		//get size of the element
		Dimension logoDim= driver.findElement(By.xpath("//*[@data-testid='StorefrontIcon']")).getSize();
		System.out.println("TH Store logo height "+logoDim.height);
		System.out.println("TH Store logo with "+logoDim.width);
		
		//get location of element x, y
		Point logoLocation= driver.findElement(By.xpath("//*[@data-testid='StorefrontIcon']")).getLocation();
		System.out.println("TH Store logo x axis "+logoLocation.x);
		System.out.println("TH Store logo y axis "+logoLocation.y);
		
		//verify if element is displayed or not
		boolean isLogoDisplayed= driver.findElement(By.xpath("//*[@data-testid='StorefrontIcon']")).isDisplayed();
		Assert.assertTrue(isLogoDisplayed);
		
		//verify if element is enabled or not
		boolean isSubmitClickable= driver.findElement(By.id("submit")).isEnabled();
		Assert.assertTrue(isSubmitClickable);
		
		//verify if radio button is selected or not
		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}


}
