package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	
	public static WebDriver driver;
	
	@BeforeTest
	public static void precondition() {
		  // setup the chrome driver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        driver = new ChromeDriver();

        // Enter URL
        driver.get("https://www.test-how.com/demo/thstore/v1/signup");
        
        //setting driver timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
    public static void fillForm() {
		//find an element by className
        driver.findElement(By.className("MuiInputBase-input")).sendKeys("newUser@gmail.com");
        
        //find an element by id
        driver.findElement(By.id("name")).sendKeys("Venkatesureddy");
        
        //find an element by name
        driver.findElement(By.name("password")).sendKeys("secret12345");
        
        //find an element by xpath
        driver.findElement(By.xpath("//input[@name='retypePassword']")).sendKeys("secret12345");
        
        //find an element by tagName
        driver.findElement(By.tagName("button")).click();
        
        //find an element by linktext
        driver.findElement(By.linkText("Forgot password?")).click();
        
        //find an element by partial linktext
        driver.findElement(By.partialLinkText("Don't have")).click();
        
    }
	
	@Test
	public void xpathFunctions() {
		
		//contains
		driver.findElement(By.xpath("//*[contains(@class, 'Avatar')]"));
		//starts-with
		driver.findElement(By.xpath("//*[starts-with(@class, 'MuiSvg')]"));
		//text
		driver.findElement(By.xpath("//label[text()='Email']"));
		//multiple conditions
		driver.findElement(By.xpath("//*[starts-with(@class, 'MuiSvg') and @data-testid='HowToRegIcon']"));
	}
	
	
	//you have to execute after test
	@AfterTest //annotation
	public void endTest() {
		 // stop the driver
        driver.quit();
	}

}


