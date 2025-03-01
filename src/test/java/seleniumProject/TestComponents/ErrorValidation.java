package seleniumProject.TestComponents;

import org.testng.annotations.Test;



import seleniumProject.Test.BaseTest;
import seleniumProject.Test.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test(retryAnalyzer =Retry.class)
	public void loginErrorValidation() {
		landingpage.loginPage("hnharsha83@gmail.com", "Harsha123");
		org.testng.Assert.assertEquals(landingpage.getErrorMsg(), "Incorrect email or password.");
		
		
	}

}
