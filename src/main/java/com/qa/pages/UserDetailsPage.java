package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.base.BasePage;

/**
 * @author tanvig
 *
 * 
 */
public class UserDetailsPage extends BasePage {

	public String getTitle() {

		return driver.getTitle();
	}

	public String getUserName() {
		String usernameCreated = driver.findElement(By.xpath(OR.getProperty("userNameTitle"))).getText();
		log.debug("getUserName called ::" + usernameCreated);
		return usernameCreated;

	}

	public String fetchUserCreateMsg() {
		String msg = driver.findElement(By.xpath(OR.getProperty("userCreateMsg"))).getText();
		log.debug("fetchUserCreateMsg called ::" + msg);
		return msg;
	}
}
