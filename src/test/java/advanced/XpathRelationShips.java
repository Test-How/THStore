package advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathRelationShips {

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		 //add chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        
        // Create driver instance with options
        driver = new ChromeDriver(options); 
		
		//configure timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

		// Enter URL
		driver.get("https://www.test-how.com/demo/thstore/v1/login");
		
	}
	
	@Test
	public static void xpathRelationships() {
		
		//login
		driver.findElement(By.id("email")).sendKeys("gvreddy1265@gmail.com");
		driver.findElement(By.id("password")).sendKeys("welcome1234");
		driver.findElement(By.id("submit")).click();
		
	
		//==============DOWN==========================//
		//by child
		WebElement footerMessage= driver.findElement(By.xpath("//footer/child::p"));
		System.out.println("footer Message: "+footerMessage.getText());
		
		//by following-sibling
		WebElement price= driver.findElement(By.xpath("//h5[text()='Nike Air Max97']/following-sibling::p"));
		System.out.println("Price is "+price.getText());
				
		
		//by following
		WebElement addToCart=driver.findElement(By.xpath("//h5[text()='Nike Air Max97']/following::button"));
		addToCart.click();
		
		//by descendant
		WebElement resetCart=driver.findElement(By.xpath("//div[contains(@class, 'MuiStack-root')]/descendant::button[text()='Reset Cart']"));
		resetCart.click();
		
		//==============UP==========================//

		//by parent
		WebElement headerText=driver.findElement(By.xpath("//button[text()='Goto Cart']/parent::div/parent::div/p"));
		System.out.println(headerText.getText());
		
		//by ancestor
		WebElement headerText1= driver.findElement(By.xpath("//button[text()='Goto Cart']/ancestor::div//following::p"));
		System.out.println(headerText1.getText());
		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}

