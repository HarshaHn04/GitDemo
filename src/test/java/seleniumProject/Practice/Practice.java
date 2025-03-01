package seleniumProject.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		 
	    int sum=0;
		List<WebElement> numbers=driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr/td[4]"));
		for(int i=0;i<numbers.size();i++) {
			
		sum = sum+Integer.parseInt(numbers.get(i).getText());
		
		}
		System.out.println(sum);
		
		String[] exp =driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
		int exp2 = Integer.parseInt(exp[1].trim());
		
		Assert.assertEquals(sum, exp2);
	}

}
