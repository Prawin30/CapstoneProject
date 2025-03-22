package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;
import java.util.Objects;

public class TestListener implements ITestListener {
    private static WebDriver driver;  // ✅ Store WebDriver instance

    // ✅ Setter method to receive WebDriver from test classes
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        if (Objects.nonNull(driver)) {
            Screenshot.captureScreenshot(driver, result.getName());  // ✅ Capture screenshot on failure
        } else {
            System.out.println("WebDriver is null, cannot take a screenshot!");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not needed for now
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finished: " + context.getName());
    }
}
