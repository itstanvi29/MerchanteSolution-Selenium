package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.BasePage;
import com.qa.data.Utilities;
import com.qa.pages.NewUserPage;
import com.qa.pages.UserDetailsPage;

/**
 * @author tanvig
 *
 * 
 */
public class NewUserCreate extends BaseTest {

	NewUserPage newuser = null;
	UserDetailsPage userDetail = new UserDetailsPage();
	String username = null;

	@Test(priority = 1)
	public void verifyNewUserPageLaunch() {
		newuser = BasePage.menu.gotoNewUserScreen();
		Assert.assertEquals(newuser.getTitle(), "New User | Active Admin Depot");

	}

	@Test(priority = 2)
	public void verifyCancelButton() {

		newuser.clickCancelUser();
		Assert.assertEquals(newuser.getTitle(), "Users | Active Admin Depot");
	}

	@Test(dataProviderClass = Utilities.class, dataProvider = "user", priority = 3)
	public void testCase01NewUserCreate(String username, String password, String email) throws InterruptedException {

		newuser = BasePage.menu.gotoNewUserScreen();
		newuser.enterUserDetails(username, password, email);
		newuser.clickCreateUser();

		// verifying the title of user Detail page launched
		Assert.assertTrue(userDetail.getTitle().contains(username));

		// verifying the userName on UserDetails Page
		Assert.assertEquals(userDetail.getUserName(), username);

		// verifying the userCreated message is successfully displayed
		Assert.assertTrue(userDetail.fetchUserCreateMsg().equals("User was successfully created."));

	}
}
