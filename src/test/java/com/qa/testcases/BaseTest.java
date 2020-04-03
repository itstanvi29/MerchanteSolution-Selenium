package com.qa.testcases;

import org.testng.annotations.AfterSuite;

import com.qa.base.BasePage;

/**
 * @author tanvig
 *
 * 
 */
public class BaseTest {

	@AfterSuite
	public void tearDown() {
		BasePage.quit();
	}

}
