package com.hack2hire.appointments.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

	public static String getUIDate(Date date) {
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
		}
		catch(Exception e) {
			log.error("Error in converting date");
		}
		return null;
	}

	public static java.sql.Date getDBDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			return new java.sql.Date(sdf.parse(date).getTime());
			}
			catch(Exception e) {
				log.error("Error in converting date");
			}
			return null;
	}
}
