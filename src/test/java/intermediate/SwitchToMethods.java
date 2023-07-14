package intermediate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToMethods {

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
		driver.get("https://www.test-how.com/");
		
	}
	
	@Test
	public static void switchToWindow() {
	//click on demo apps dropdown	
	driver.findElement(By.linkText("Demo Apps")).click();
	//click on TH frames option
	driver.findElement(By.linkText("TH Frames")).click();
	
	System.out.println(driver.getTitle());
	//switch newly opened
	String thHomePageId= driver.getWindowHandle();
	System.out.println("Current window id: "+thHomePageId);
	
	Set<String> allWindowIds= driver.getWindowHandles();
	for(String windowId:allWindowIds) {
		driver.switchTo().window(windowId);
		String title= driver.getTitle();
		if(title.equals("React Frames")) {
			System.out.println("Switched to window");
			break;
		}
	}
	
	driver.switchTo().frame("nav");
	driver.findElement(By.xpath("//button[text()='Page 1']")).click();
	
	driver.switchTo().defaultContent();
	WebElement mainFrame= driver.findElement(By.xpath("//frame[@name='main']"));
	driver.switchTo().frame(mainFrame);
	
	String headerText= driver.findElement(By.tagName("h2")).getText();
	Assert.assertEquals(headerText, "Page 1: Look ma, no CSS!");
	
	//close the current tab
	driver.close();
	//switch to home page
	driver.switchTo().window(thHomePageId);
	System.out.println(driver.getTitle());
	
	}
	
	@Test
	public static void switchToAlert() {
		//click on demo apps dropdown	
		driver.findElement(By.linkText("Demo Apps")).click();
		//click on TH frames option
		driver.findElement(By.linkText("TH Store")).click();
		
		//click on forgot password
		driver.findElement(By.xpath("//button[@id='submit']//following::button")).click();
		
		Alert confirmAlert=driver.switchTo().alert();
		confirmAlert.accept();
		
		Alert emailAlert= driver.switchTo().alert();
		emailAlert.sendKeys("gvreddy1265@gmail.com");
		emailAlert.accept();
		
		Alert confirmationAlert = driver.switchTo().alert();
		String confirmMessage= confirmationAlert.getText();
		Assert.assertEquals(confirmMessage, "We have sent reset email to gvreddy1265@gmail.com");
		confirmAlert.accept();
		
		//click on forgot password
		driver.findElement(By.xpath("//button[@id='submit']//following::button")).click();
		driver.switchTo().alert().dismiss();
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
