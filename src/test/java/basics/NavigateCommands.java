package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DriverManager;

public class NavigateCommands extends DriverManager{
	

	
	@Test
	public static void navigateCommands() {
		//navigate to url
		driver.navigate().to("https://outlook.com");
		
		//navigate back
		driver.navigate().back();
		
		//navigate forward
		driver.navigate().forward();
		
		//refresh the page
		driver.navigate().refresh();
	}


}
