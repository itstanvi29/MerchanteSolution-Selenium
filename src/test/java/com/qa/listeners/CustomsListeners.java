package com.qa.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.qa.base.BasePage;

/**
 * @author tanvig
 *
 * 
 */

public class CustomsListeners extends BasePage implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		log.debug(result.getName().toUpperCase() + "  STARTED : ");

	}

	public void onTestSuccess(ITestResult result) {
		log.debug(result.getName().toUpperCase() + "  PASS : ");

	}

	public void onTestFailure(ITestResult result) {
		log.debug(result.getName().toUpperCase() + "  Failed with exception : " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		log.debug(result.getName().toUpperCase() + " SKIPPED ");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
