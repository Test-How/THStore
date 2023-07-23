package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DriverManager;

public class TimeOutPractice extends DriverManager{
	


	
	@Test
	public static void timeOutTests() {
	
		driver.findElement(By.id("email")).sendKeys("newUser@gmail.com");
		driver.findElement(By.id("name")).sendKeys("venkatesureddy");
		driver.findElement(By.id("password")).sendKeys("welcome1234");
		driver.findElement(By.id("retypePassword")).sendKeys("welcome1234");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.partialLinkText("Don't have an account?")).click();
		
	}



}
