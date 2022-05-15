package com.moneyware.digital.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String toStringFromDate(Date date) {
		return new SimpleDateFormat("yyyy/MM/dd").format(date);
	}

}
