package advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelectors {

	public static WebDriver driver;

	@BeforeTest
	public static void precondition() {
		// setup the chrome driver
		WebDriverManager.chromedriver().setup();

		// Launch Chrome browser
		driver = new ChromeDriver();

		// configure timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

		// Enter URL
		driver.get("https://www.test-how.com/demo/thstore/v1/login");

	}
	
	@Test
	public static void cssSelectors() {
		
		//xpath vs css
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("gvreddy1265@gmail.com");
		
		//id # and classname .
		driver.findElement(By.cssSelector("#password")).sendKeys("welcome1234");
		driver.findElement(By.cssSelector("#submit")).submit();
		
		//child
		WebElement footerMessageXpath= driver.findElement(By.xpath("//footer/child::p"));
		WebElement footerMessageCss= driver.findElement(By.cssSelector("footer p"));
		System.out.println(footerMessageXpath.getText() +"  "+ footerMessageCss.getText());
		
		//starts-with //span[starts-with(@class, 'MuiBadge-b')]
		WebElement badgeCount= driver.findElement(By.cssSelector("span[class^='MuiBadge-b']"));
		System.out.println("Total elements added to cart :"+badgeCount.getText());
		
		//ends-with
		badgeCount= driver.findElement(By.cssSelector("span[class$='-invisible']"));
		System.out.println("Total elements added to cart :"+badgeCount.getText());

		//contains
		badgeCount= driver.findElement(By.cssSelector("span[class*='-badge']"));
		System.out.println("Total elements added to cart :"+badgeCount.getText());

		
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
