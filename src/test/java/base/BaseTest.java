package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;

public class BaseTest {
	
	 public static WebDriver driver;

	    @BeforeMethod
	    public void setup() {

	        driver =DriverFactory.initializeBrowser();

	    }

	    @AfterMethod
	    public void tearDown() {

	        DriverFactory.quitBrowser();

	    }

}
