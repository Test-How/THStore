package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogPage {

  WebDriver driver;
	
	public ProductCatalogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Goto Cart']/parent::div/parent::div/p")
	public WebElement header;
	
	@FindBy(xpath="//h5[text()='Nike Air Max97']/following::button")
	public WebElement addToCartButton;
	
	@FindBy(xpath="//h5[text()='Nike Air Max97']/following::button/following::button")
	public WebElement removeFromCart;
	
	@FindBy(xpath="//span[contains(@class,'MuiBadge-badge')]")
	public WebElement cart;
	
	
	public String getHeaderText() {
		return header.getText();
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	
	public void removeItemFromCart() {
		removeFromCart.click();
	}
	
	public String getCurrentCountofCart() {
		return cart.getText();
	}
}
