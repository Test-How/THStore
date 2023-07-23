package intermediate;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	
		driver.get("https://oneauto.github.io/Test/Actions.html");
		
	}
	
	@Test
	public static void actionClassMethods() {
	
		//click on demo apps dropdown	
		WebElement option= driver.findElement(By.className("tooltip"));
		//mouse over
		Actions action= new Actions(driver);
		action.moveToElement(option).build().perform();
		
		WebElement tooltip= driver.findElement(By.className("tooltiptext"));
		Assert.assertEquals(tooltip.getText(), "Tooltip text");
		
		
		//context click
		action.contextClick(option).build().perform();
		driver.findElement(By.tagName("h2")).click();
		
		//double click
		action.doubleClick(driver.findElement(By.tagName("h2"))).build().perform();
				
		
		//multiple keys Ctrl+A
		// Select all by simulating CTRL+A
		action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
		// Copy by simulating CTRL+C
		action.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();

	
		
		
		driver.get("https://demoqa.com/droppable/");
		WebElement from = driver.findElement(By.id("draggable"));
		 
		WebElement to = driver.findElement(By.id("droppable"));	
		
		action.dragAndDrop(from, to).perform();
		
	
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}
}
