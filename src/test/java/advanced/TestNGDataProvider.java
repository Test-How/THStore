package advanced;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductCatalogPage;
import pages.SignUpPage;
import util.DriverManager;

public class TestNGDataProvider extends DriverManager {
	
	@BeforeMethod
	public void loadSignupPage() {
		driver.get("https://www.test-how.com/demo/thstore/v1/signup");
	}

	@Test(dataProvider="userdata")
	public void signupTest(String email, String name, String pswd) {
		SignUpPage signupPage = PageFactory.initElements(driver, SignUpPage.class);

		signupPage.enterEmail(email);
		signupPage.enterName(name);
		signupPage.enterPassword(pswd);
		signupPage.retypePassword(pswd);
		signupPage.clickOnSubmitButtn();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("login"));

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		Assert.assertEquals(loginPage.getHeaderText(), "Sign in");
		loginPage.enterEmail(email);
		loginPage.enterPassword(pswd);
		loginPage.clickOnSignIn();
		
		wait.until(ExpectedConditions.urlContains("Shop"));
		
		ProductCatalogPage productPage= PageFactory.initElements(driver, ProductCatalogPage.class);
		String expectedHeader= "Welcome to TH Store";
		Assert.assertEquals(productPage.getHeaderText(), expectedHeader, "Did not landed in product catalog page");

	}
	
	@DataProvider(name="userdata")
	public Object[][] generateSignupTestData() {
		return new Object[][] {
			{"alex@gmail.com", "Alex", "hello1234"},
			{"kennedy@gmail.com", "kennedy", "welcome1299"},
			{"raghu@gmail.com", "Raghu", "missi"},
			};
	}
	
	@Test(dataProvider = "invalidName")
	public void validateNameField(String invalidName) {
		SignUpPage signupPage = PageFactory.initElements(driver, SignUpPage.class);

		
		signupPage.enterName(invalidName);
		signupPage.clickOnSubmitButtn();
		
		//assertion whether expected error occorred or not
	}
	
	@DataProvider(name="invalidName")
	public Object[][] generateInvalidNames() {
		return new Object[][] {
			{"abc a"}, {"hel@"}, {"xc s"}
			};
	}
}
