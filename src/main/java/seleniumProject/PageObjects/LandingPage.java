package seleniumProject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumProject.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement EmailId;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(css="input[class*='login-btn']")
	WebElement Login;
	
	@FindBy(css=".toast-error")
	WebElement errormsg;
	
	By findby = By.cssSelector(".toast-error");
	
	
	public ProductCatalogue loginPage(String UserEmail,String UserPassword) {
		
		EmailId.sendKeys(UserEmail);
		Password.sendKeys(UserPassword);
		Login.click();
		
		return new ProductCatalogue(driver);
		
	}

	public void GoTO() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMsg() {
		
		waitUnitlElementToAppear(findby);
		return errormsg.getText();
		
		
	}
	
	

}
