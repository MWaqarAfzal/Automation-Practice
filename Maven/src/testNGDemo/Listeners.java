package testNGDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Hello this is listeners Test Success Method");
	  }
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Hello this is listeners Test Failure Method and test case " + result.getName() + " is failed");
	  }
	
	@Override
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }
	
	@Override
	public void onStart(ITestContext context) {
	    // not implemented
	  }
	
	@Override
	public void onFinish(ITestContext context) {
	    // not implemented
	  }
	
}
