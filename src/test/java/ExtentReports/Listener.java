package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Utilities.Screenshots;

public class Listener implements ITestListener {

    private static ExtentReports extent;
    private static ExtentTest extentTest;
    private Screenshots screenshots = new Screenshots();

    @Override
    public void onTestStart(ITestResult result){
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testMethodName = result.getMethod().getMethodName();
        Throwable throwable = result.getThrowable();

        extentTest.log(Status.FAIL,"Test Case "+ testMethodName + " Has failed");

        if (throwable != null) {
            extentTest.log(Status.FAIL, "Failure Reason: " + throwable.getMessage());
        }

        try {
            Object testInstance = result.getInstance();
            if (testInstance != null) {
                WebDriver driver = (WebDriver) testInstance.getClass().getField("driver").get(testInstance);
                String screenshotName = testMethodName + "_FAILED";
                screenshots.takesSnapShot(driver, screenshotName);
                extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + ".jpeg");
            }
        } catch (Exception e) {
            extentTest.log(Status.WARNING, "Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        extentTest.log(Status.PASS,"Test Case "+ result.getMethod().getMethodName() + " Has Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extentTest.log(Status.SKIP,"Test Case "+ result.getMethod().getMethodName() + " Has been Skipped");
    }

    @Override
    public void onFinish(ITestContext result){
        extent.flush();
    }

    @Override
    public void onStart(ITestContext result){
        extent = ExtentReportManager.extentReports();
    }


}