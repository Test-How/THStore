package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowCommands {
	

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
	public static void windowCommands() {
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().window().setSize(new Dimension(100, 100));
		driver.manage().window().setPosition(new Point(30,40));
		
		Point pos=driver.manage().window().getPosition();
		System.out.println(pos.x +" "+pos.y);
		Dimension size=driver.manage().window().getSize();
		System.out.println(size.height+" "+size.width);
	}

	// you have to execute after test
	@AfterTest // annotation
	public void endTest() {
		// stop the driver
		driver.quit();
	}


}
