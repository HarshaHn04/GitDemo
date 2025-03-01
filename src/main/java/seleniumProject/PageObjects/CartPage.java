package seleniumProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumProject.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='cartSection'] h3")
	List<WebElement> cartItems;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOut;
	
	By cartProd = By.cssSelector("div[class='cartSection']");

	public Boolean verifyCartItems(String product) {
		Boolean match = getListOfCartItmes().stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(product));
		return match;

	}

	public List<WebElement> getListOfCartItmes() {
		waitUnitlElementToAppear(cartProd);
		return cartItems;
	}
	
	public CheckOutPage checkOut() {
		
		checkOut.click();
		return new CheckOutPage(driver);
	}

}
