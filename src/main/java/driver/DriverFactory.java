package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
public static WebDriver driver;

public static WebDriver initializeBrowser()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	 
}

public static WebDriver getDriver()
{
	return driver;
}

public static void quitBrowser() {

    if(driver!=null)
    {
        driver.quit();
        driver =null;

    }
}
}
