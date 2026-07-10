package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	private static ExtentReports extent;

    public static ExtentReports getExtentReport() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String reportPath ="./Reports/AutomationReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("AI Automation Framework");
            sparkReporter.config().setReportName("Automation Test Execution Report");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Soham Chakraborty");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        }

        return extent;
    }

}
