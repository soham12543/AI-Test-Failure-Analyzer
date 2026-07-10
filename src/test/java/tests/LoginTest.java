package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void logintest() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		LoginPage lp=new LoginPage(driver);
		lp.login("standard_user","secretsauce");
	    Assert.assertTrue(lp.isProductsPageDisplayed(),
	            "Login was unsuccessful.");
	    
	    
	}

}
