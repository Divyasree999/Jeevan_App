package com.cg.jeevanonlineterminsurance.exception;
import java.util.regex.Matcher;
/*
 * Validation
 * @author - Poorani
 */
import java.util.regex.Pattern;
public class AdminValidation {
	public boolean validateAdminId(Integer adminId) {
		String regex = "^[0-9]{8}*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		matcher = pattern.matcher(String.valueOf(adminId));
		return matcher.matches();
	}
}
