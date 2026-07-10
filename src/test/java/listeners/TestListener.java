package listeners;
import ai.AIService;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentManager;
import utility.ScreenshotUtility;

public class TestListener implements ITestListener {
	   ExtentReports extent = ExtentManager.getExtentReport();
	    ExtentTest test;

	    @Override
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result)
	    {
	        test.fail(result.getThrowable());

	        String testName = result.getMethod().getMethodName();

	        try {

	            String path = ScreenshotUtility.caprturescreenshot(BaseTest.driver, testName);
	            test.addScreenCaptureFromPath(path);
	            String currentURL = BaseTest.driver.getCurrentUrl();
	            String pageTitle = BaseTest.driver.getTitle();
	            String exception = result.getThrowable().toString();
	           // String browser = BaseTest.driver.getCapabilities().getBrowserName();

	            // ================= AI ANALYSIS =================
	            AIService ai = new AIService();

	            String analysis = ai.analyzeFailure(
	                    testName,
	                    exception,
	                    currentURL,
	                    pageTitle,
	                    path,
	                    "Locator not available");

	            test.info("<h3>🤖 AI Failure Analysis</h3>");
	            test.info("<pre>" + analysis + "</pre>");

	            // ==============================================

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

}
