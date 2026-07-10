package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtility {
	
	
	public static String caprturescreenshot(WebDriver driver, String testName) throws IOException
	{
		String folderPath = System.getProperty("user.dir") + "/Screenshots";
        File folder = new File(folderPath);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = folderPath + "/" + testName + "_" + timestamp + ".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		Files.copy(src, dest);
		return path;
		
	}

}
