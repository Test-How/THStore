package intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		driver = new ChromeDriver();
		
		//configure timeout
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

		// Enter URL
		driver.get("https://www.test-how.com/demo/thstore/v1/signup");
		
	}
	
	@Test
	public static void webTableTests() {
	
		//validate that table headers are (2 th) Name and Info
		List<String> expectedHeaders= new ArrayList<String>();
		expectedHeaders.add("Name");
		expectedHeaders.add("Info");
		
		List<String> actualHeaders= new ArrayList<String>();
		//Extract actual headers
		driver.findElement(By.xpath("//table/thead/tr[1]/th"));
		List<WebElement> headers=driver.findElements(By.xpath("//table/thead/tr[1]/th"));
		for(WebElement header:headers) {
			actualHeaders.add(header.getText());
		}
		
		//validate the count
		Assert.assertEquals(expectedHeaders.size(), actualHeaders.size());
		System.out.println(actualHeaders);
		System.out.println(expectedHeaders);
		Assert.assertTrue(expectedHeaders.equals(actualHeaders));
		
		
		
	}
	
	@Test
	public static void validateRowsCount() {
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		//validate that there are 10 rows in  body
		Assert.assertEquals(rows.size(), 10);
	}
	
	@Test
	public static void jsexecutorTest() {
		 //Creating the JavascriptExecutor interface object by Type casting        
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  WebElement email=driver.findElement(By.id("email"));
		  
		  //Perform Click on button using JavascriptExecutor        
		  js.executeScript("arguments[0].value='IamNewUser@gmail.com'", email);
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
