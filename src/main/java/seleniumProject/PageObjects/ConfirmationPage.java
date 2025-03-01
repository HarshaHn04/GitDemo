package seleniumProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumProject.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(xpath="//h1[text()=' Thankyou for the order. ']")
	WebElement confirmMessage;
	
	public String getConfirmMessage() {
		
		String cfmMsg =confirmMessage.getText();
		return cfmMsg;
		
		
		
		
	}

}
