package com.qa.data;

import org.testng.annotations.DataProvider;
import com.qa.base.BasePage;

/**
 * @author tanvig
 *
 * 
 */

public class Utilities extends BasePage {

	@DataProvider(name = "user")
	public Object[][] getData() {

		Object[][] data = new Object[2][3];
		data[0][0] = "Ivaan";
		data[0][1] = "Saggg23412";
		data[0][2] = "ivan@gmail.com";

		
		  data[1][0] = "Ivan345"; data[1][1] = "Samivan14y"; data[1][2] =
		  "ivan345@gmail.com";
		 
		return data;

	}

	@DataProvider(name = "filter")
	public Object[][] getData1() {

		Object[][] data = new Object[2][7];
		data[0][0] = "username_contains";
		data[0][1] = "email_contains";
		data[0][2] = "Sam";
		data[0][3] = "Sam";
		data[0][4] = "10-02-2020";
		data[0][5] = "10-07-2020";
		data[0][6] = "true";

		
		  data[1][0] = "username_contains"; data[1][1] = "email_contains"; data[1][2] =
		  "Sam"; data[1][3] = "Sam"; data[1][4] = "10-04-2020"; data[1][5] =
		  "10-05-2020"; data[1][6] = "false";
		 

		return data;

	}

}
