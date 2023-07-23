package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	WebDriver driver;

	// page objects
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "name")
	public WebElement name;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='retypePassword']")
	public WebElement retypePassword;

	@FindBy(id = "submit")
	public WebElement submit;

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pagemethods
	public void enterEmail(String userEmail) {
		email.sendKeys(userEmail);
	}
	
	public void enterName(String userName) {
		name.sendKeys(userName);
	}
	
	public void enterPassword(String passwd) {
		password.sendKeys(passwd);
	}
	
	public void retypePassword(String retypePswd) {
		retypePassword.sendKeys(retypePswd);
	}

	// page methods
	public void signup(String userEmail, String passwd, String userName) {

		email.sendKeys(userEmail);
		password.sendKeys(passwd);
		retypePassword.sendKeys(passwd);
		name.sendKeys(userName);
		submit.click();
	}

	public void clickOnSubmitButtn() {
		this.submit.click();
	}

}
