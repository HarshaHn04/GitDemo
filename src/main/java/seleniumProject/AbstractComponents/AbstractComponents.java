package seleniumProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumProject.PageObjects.CartPage;
import seleniumProject.PageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponents(WebDriver driver) {
		
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(xpath="(//button[@class='btn btn-custom'])[3]")
	WebElement cartButton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderPage;
	
	
	public void waitUnitlElementToAppear(By findby) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	public void waitForElementToDisappear(By findby) {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	
	public void waitForElementToInvisible(WebElement pageSpin) {
		
		wait.until(ExpectedConditions.invisibilityOf(pageSpin));
	}
	
	public CartPage goToCart() {
		
		cartButton.click();
		return new CartPage(driver);	
	}
	
	public OrdersPage goToOrdersPage() {
		
		orderPage.click();
		return new OrdersPage(driver);
		
		
	}

}
