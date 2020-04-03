package com.qa.utilities;

import java.util.Calendar;

/**
 * @author tanvig
 *
 * 
 */
public class HandlingCalenders {

	static int targetDay = 0, targetMonth = 0, targetYear = 0;
	static int currentDay = 0, currentMonth = 0, currentYear = 0;
	static int jumpMonthsBy = 0;
	static boolean increment = true;

	public static int GetTargetDateMonthAndYear(String dateString) {

		System.out.println("date--" + dateString);

		int firstIndex = dateString.indexOf("-");
		int lastIndex = dateString.lastIndexOf("-");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);

		return targetDay;

	}

	public static String CalculateHowManyMonthsToJump() {

		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);

		if ((targetMonth - currentMonth) > 0) {
			jumpMonthsBy = (targetMonth - currentMonth);
			increment = true;
			return jumpMonthsBy + "~" + increment;
		} else {
			jumpMonthsBy = (currentMonth - targetMonth);
			increment = false;
			return jumpMonthsBy + "~" + increment;
		}

	}

}
