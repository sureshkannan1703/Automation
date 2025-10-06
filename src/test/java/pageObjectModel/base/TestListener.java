package pageObjectModel.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("All tests completed.");
    }
}
