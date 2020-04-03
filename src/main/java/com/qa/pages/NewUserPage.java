package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.base.BasePage;

/**
 * @author tanvig
 *
 * 
 */
public class NewUserPage extends BasePage {

	public String getTitle() {
		String title = driver.getTitle();
		log.debug("getTitle ::" + title);
		return title;

	}

	public void enterUserDetails(String username, String password, String email) {
		driver.findElement(By.xpath(OR.getProperty("userTextBox"))).sendKeys(username);
		driver.findElement(By.xpath(OR.getProperty("pwdTextBox"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("emailTextBox"))).sendKeys(email);
		log.debug("enterUserDetails called :: values entered :: " + username + " " + password + " " + email);

	}

	public void clickCreateUser() {
		driver.findElement(By.xpath(OR.getProperty("createUserbutton"))).click();
		log.debug("clickCreateUser called :: createButtonclicked");

	}

	public void clickCancelUser() {
		driver.findElement(By.xpath(OR.getProperty("cancelButton"))).click();
		log.debug("clickCancelUser called :: cancelButtonclicked");

	}

}
