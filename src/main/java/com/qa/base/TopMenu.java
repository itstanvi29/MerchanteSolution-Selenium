package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.pages.FilterUserPage;
import com.qa.pages.NewUserPage;

/**
 * @author tanvig
 *
 * 
 */
public class TopMenu {

	WebDriver driver;
	Properties OR;

	public TopMenu(WebDriver driver, Properties OR) {

		this.driver = driver;
		this.OR = OR;
	}

	public FilterUserPage gotoFilterUserPage() {

		this.driver.findElement(By.xpath(OR.getProperty("userMenu"))).click();
		return new FilterUserPage();
	}

	public NewUserPage gotoNewUserScreen() {
		WebElement newUser = null;
		this.driver.findElement(By.xpath(OR.getProperty("userMenu"))).click();
		newUser = this.driver.findElement(By.xpath(OR.getProperty("newUserButton")));
		newUser.click();
		return new NewUserPage();
	}

}
