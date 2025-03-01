package seleniumProject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumProject.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement pageSpin;

	By findby = By.cssSelector(".mb-3");
	By toastMsg = By.cssSelector("div[class*='toast-message']");
	By spin = By.cssSelector(".ng-animating");
	By addToCart = By.cssSelector(".btn.w-10.rounded");
	
	
	public WebElement getProductName(String productName) {
		WebElement prod = getListOfProducts().stream().filter(product->product.findElement(By.cssSelector("h5 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCart).click();
		waitUnitlElementToAppear(toastMsg);
		waitForElementToInvisible(pageSpin);
	}

	public List<WebElement> getListOfProducts() {

		waitUnitlElementToAppear(findby);
		return products;

	}

}
