package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.base.TopMenu;
import com.qa.data.Utilities;
import com.qa.pages.FilterUserPage;

/**
 * @author tanvig
 *
 * 
 */
public class FilterUser extends BaseTest {

	FilterUserPage filterUserPage=null;
	String username = null;

	@Test(dataProviderClass = Utilities.class, dataProvider = "filter")
	public void testCases02FilterUser(String userFilter, String emailFilter, String userValue, String emailValue,
			String startDate, String endDate, String isDataPresent) throws InterruptedException  {

		
		filterUserPage= BasePage.menu.gotoFilterUserPage();
		
		filterUserPage.clickClearFilter();

		filterUserPage.selectUserNamefilter(userFilter);
		filterUserPage.enterUserName(userValue);

		filterUserPage.selectEmailfilter(emailFilter);
		filterUserPage.enterEmail(emailValue);

		filterUserPage.enterCreateFromDateValue(startDate);
		filterUserPage.enterCreateEndDateValue(endDate);
		
		filterUserPage.clickFilter();

		//Thread.sleep(6000);
		int countOfdata = filterUserPage.getDataCount();
		if (isDataPresent.equalsIgnoreCase("TRUE")) {
			// verifying the data is displayed
			Assert.assertTrue(countOfdata >= 1);
		} else {

			Assert.assertFalse(countOfdata >= 1);
		}

	}

}
