package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.BasePage;
import com.qa.utilities.HandlingCalenders;

/**
 * @author tanvig
 *
 * 
 */
public class FilterUserPage extends BasePage {

	public void selectUserNamefilter(String filterType) {
		Select userDropdown = new Select(driver.findElement(By.xpath(OR.getProperty("userNameFilter"))));
		userDropdown.selectByValue(filterType);
		log.debug("selectUserNamefilter called ::user filter used :: " + filterType);
	}

	public void enterUserName(String userNameValue) {
		driver.findElement(By.xpath(OR.getProperty("userNameValue"))).sendKeys(userNameValue);
		log.debug("enterUserName called ::user value used :: " + userNameValue);
	}

	public void selectEmailfilter(String filterType) {
		Select emailDropdown = new Select(driver.findElement(By.xpath(OR.getProperty("emailFilter"))));
		emailDropdown.selectByValue(filterType);
		log.debug("selectEmailfilter called ::email filter used :: " + filterType);

	}

	public void enterEmail(String emailValue) {
		driver.findElement(By.xpath(OR.getProperty("emailValue"))).sendKeys(emailValue);
		log.debug("enterEmail called ::email value used :: " + emailValue);
	}

	public void enterCreateFromDateValue(String createFromDate) {

		log.debug("enterCreateFromDateValue start");

		int targetDay = HandlingCalenders.GetTargetDateMonthAndYear(createFromDate);
		String[] data = HandlingCalenders.CalculateHowManyMonthsToJump().split("~");

		int jumpMonthsBy = Integer.parseInt(data[0]);
		String increment = data[1];

		System.out.println("targt day " + targetDay + " " + jumpMonthsBy + " " + increment);
		driver.findElement(By.xpath(OR.getProperty("startDate"))).click();

		if (jumpMonthsBy != 0) {
			for (int i = 0; i < jumpMonthsBy; i++) {
				if (increment.equalsIgnoreCase("true")) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("nextArrow")))).click();
					//driver.findElement(By.xpath(OR.getProperty("nextArrow"))).click();
				} else {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("prevArrow")))).click();
					
					//driver.findElement(By.xpath(OR.getProperty("prevArrow"))).click();

				}
			}
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();

		// driver.findElement(By.xpath(OR.getProperty("startDate"))).sendKeys(createFromDate);
		log.debug("enterCreateFromDateValue called ::startDate value used :: " + createFromDate);
	}

	public void enterCreateEndDateValue(String createEndDate) {

		log.debug("enterCreateEndDateValue start");

		int targetDay = HandlingCalenders.GetTargetDateMonthAndYear(createEndDate);
		String[] data = HandlingCalenders.CalculateHowManyMonthsToJump().split("~");

		int jumpMonthsBy = Integer.parseInt(data[0]);
		String increment = data[1];

		System.out.println("targt day " + targetDay + " " + jumpMonthsBy + " " + increment);
		driver.findElement(By.xpath(OR.getProperty("endDate"))).click();

		if (jumpMonthsBy != 0) {
			for (int i = 0; i < jumpMonthsBy; i++) {
				if (increment.equalsIgnoreCase("true")) {
					//driver.findElement(By.xpath(OR.getProperty("nextArrow"))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("nextArrow")))).click();
					
				} else {
					//driver.findElement(By.xpath(OR.getProperty("prevArrow"))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("prevArrow")))).click();
					

				}
			}
		}
		driver.findElement(By.linkText(Integer.toString(targetDay))).click();

		// driver.findElement(By.xpath(OR.getProperty("endDate"))).sendKeys(createEndDate);
		log.debug("enterCreateEndDateValue called ::endDate value used :: " + createEndDate);
	}

	public void clickFilter() {
		driver.findElement(By.xpath(OR.getProperty("commitButton"))).click();
		log.debug("clickFilter called :: submitfilter clicked");
	}

	public void clickClearFilter() {
		driver.findElement(By.xpath(OR.getProperty("clearFilter"))).click();
		log.debug("clickClearFilter called :: clearfilter clicked");
	}

	public int getDataCount() {

		List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("displayTable")));
		int rowSize = rows.size();
		log.debug("getDataCount called :: no of userDataDispalyed :: " + rowSize);
		return rowSize;
	}
}
