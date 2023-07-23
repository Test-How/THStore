package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page objects
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="submit")
	public WebElement signIn;
	
	@FindBy(xpath="//h1[text()='Sign in']")
	public WebElement header;
	
	
	//page Methods
	public String getHeaderText() {
		return header.getText();
	}
	public void enterEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void enterPassword(String pswd) {
		password.sendKeys(pswd);
	}
	
	public void clickOnSignIn() {
		signIn.click();
	}
}
