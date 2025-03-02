package seleniumProject.TestComponents;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import seleniumProject.PageObjects.CartPage;
import seleniumProject.PageObjects.CheckOutPage;
import seleniumProject.PageObjects.ConfirmationPage;
import seleniumProject.PageObjects.OrdersPage;
import seleniumProject.PageObjects.ProductCatalogue;
import seleniumProject.Test.BaseTest;

public class SubmitOrder extends BaseTest{
	
	//SubmitOrder
	@Test(dataProvider = "getData")
	public void PurchaseOrder(HashMap<String,String> input) throws IOException {
		
		String country = "India";
		
		
		ProductCatalogue productcatalogue = landingpage.loginPage(input.get("email"), input.get("password"));
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartpage =productcatalogue.goToCart();
		Boolean match = cartpage.verifyCartItems(input.get("product"));
		org.testng.Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.checkOut();
		checkoutpage.selectCountry(country);
		ConfirmationPage confirmationpage = checkoutpage.placeOrder();
		Assert.assertTrue(confirmationpage.getConfirmMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dataProvider="getData",dependsOnMethods = "PurchaseOrder")
	public void orderValidation(HashMap<String,String> input) {
		
		ProductCatalogue productcatalogue = landingpage.loginPage(input.get("email"), input.get("password"));
		OrdersPage orderpage = productcatalogue.goToOrdersPage();
		Boolean match = orderpage.verifyOrderedProd(input.get("product"));
		Assert.assertTrue(match);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = (List<HashMap<String,String>>) getJsonDataToMaop(System.getProperty("user.dir")+"\\src\\test\\java\\seleniumProject\\Data\\InputData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
	}

	
}
