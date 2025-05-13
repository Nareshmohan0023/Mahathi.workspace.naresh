package com.management.utils;

public class EmailGenerator {

	public static String generateEmail(String employeeName) {
		if (employeeName == null || employeeName.trim().isEmpty()) {
			return "unknown@mahathi";
		}
		String localPart = employeeName.trim().toLowerCase().replaceAll("\\s+", "");
		return localPart + "@mahathi";
	}

}
