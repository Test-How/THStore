package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SignUpPage;
import util.DriverManager;
import util.Reusable;

public class Locators extends DriverManager {
	
	
	@Test
    public static void fillForm() throws Exception {
		
		//create an object to pagefactory class
		SignUpPage signupPage= PageFactory.initElements(driver, SignUpPage.class);
		signupPage.signup("gvreddy@hj.com", "venkat", "secret");
    }
	
	@Test
	public void xpathFunctions() {
		
		//contains
		driver.findElement(By.xpath("//*[contains(@class, 'Avatar')]"));
		//starts-with
		driver.findElement(By.xpath("//*[starts-with(@class, 'MuiSvg')]"));
		//text
		driver.findElement(By.xpath("//label[text()='Email']"));
		//multiple conditions
		driver.findElement(By.xpath("//*[starts-with(@class, 'MuiSvg') and @data-testid='HowToRegIcon']"));
		SignUpPage signupPage= PageFactory.initElements(driver, SignUpPage.class);
		signupPage.clickOnSubmitButtn();
	}
	
	
	

}


