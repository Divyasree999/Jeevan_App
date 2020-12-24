package com.cg.jeevanonlineterminsurance.exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PaymentValidation {

	public boolean validatePaymentId(Integer paymentId) {
		String regex="^[0-9]{7}*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = null;
		matcher = pattern.matcher(String.valueOf(paymentId));
		return matcher.matches();
	}
}
