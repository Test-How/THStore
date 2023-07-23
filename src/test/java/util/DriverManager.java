package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
public static WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"})
	public static void precondition(@Optional("chrome") String browser) throws Exception {
		
		System.out.println("current browser selection is "+ browser);
		if(browser.equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
		}else if(browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
		}else {
			throw new Exception("No such Browser found");
		}
	

        // Enter URL
        driver.get("https://www.test-how.com/demo/thstore/v1/signup");
        
        //setting driver timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//you have to execute after test
		@AfterTest //annotation
		public void endTest() {
			 // stop the driver
	        driver.quit();
		}

}
