package tests;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductCatalogPage;
import pages.SignUpPage;
import util.DriverManager;

public class SignupPageTest extends DriverManager{
	
	@Test
	public void signUpHpppyPathTest() {
		SignUpPage signupPage= PageFactory.initElements(driver, SignUpPage.class);
		
		signupPage.enterEmail("newuser@gmail.com"); //hard code test data , wired test data
		signupPage.enterName("Venkatesureddy");
		signupPage.enterPassword("welcome1234");
		signupPage.retypePassword("welcome1234");
		signupPage.clickOnSubmitButtn();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("login"));
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		
		Assert.assertEquals(loginPage.getHeaderText(), "Sign in");
		
		loginPage.enterEmail("newuser@gmail.com");
		loginPage.enterPassword("welcome1234");
		loginPage.clickOnSignIn();
		
		wait.until(ExpectedConditions.urlContains("Shop"));
		
		ProductCatalogPage productPage= PageFactory.initElements(driver, ProductCatalogPage.class);
		String expectedHeader= "Welcome to TH Store";
		
		Assert.assertEquals(productPage.getHeaderText(), expectedHeader, "Did not landed in product catalog page");
	}
	
	@Test
	public void validateAddtoCartAndRemoveFunctionality() {
		
		ProductCatalogPage productPage= PageFactory.initElements(driver, ProductCatalogPage.class);
		Assert.assertEquals(productPage.getCurrentCountofCart(), "0");
		
		productPage.clickOnAddToCartButton();
		Assert.assertEquals(productPage.getCurrentCountofCart(), "1");
		
		productPage.removeItemFromCart();
		Assert.assertEquals(productPage.getCurrentCountofCart(), "0");
	}
	

}
