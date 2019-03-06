package com.avlview.listners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.avlview.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	public CustomListeners() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String messageBody;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {

		// String screenshotPath = null;

		// test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception
		// : "+arg0.getThrowable());
		// test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		test.log(LogStatus.FAIL, "Test case failed is  " + arg0.getName());
		test.log(LogStatus.FAIL, "Test case failed is  " + arg0.getThrowable());

		// String screenshotPath = null;

		// test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

		// test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Skipped the test as
		// the Run mode is NO");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult arg0) {

		test.log(LogStatus.SKIP, arg0.getName());
		rep.endTest(test);
		rep.flush();

	}

	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName());

	}

	public void onTestSuccess(ITestResult arg0) {

		test.log(LogStatus.PASS, arg0.getName() + " PASS");
		rep.endTest(test);
		rep.flush();

	}

	public void onFinish(ISuite arg0) {

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

}
