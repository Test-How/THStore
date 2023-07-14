package intermediate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassMethods {

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
	public static void actionClassMethods() {
	
		//click on demo apps dropdown	
		WebElement demoAppsButton= driver.findElement(By.linkText("Demo Apps"));
		
		Actions action= new Actions(driver);
		action.moveToElement(demoAppsButton).build().perform();
		
		WebElement option= driver.findElement(By.linkText("TH Store"));
		action.moveToElement(option).click().build().perform();
		
		driver.get("https://rmodmn.csb.app/");
		
		WebElement card3=driver.findElement(By.id("3"));
		//WebElement Inprogress= driver.findElement(By.xpath("//h4[text()='In Progress']/ancestor::div[@class='drag_column']"));
		WebElement card2=driver.findElement(By.id("2"));
		//moving card 2 to inprogress
		action.dragAndDrop(card3, card2).build().perform();
		
		
		//moving card 2 to completed
		
		System.out.println();
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
