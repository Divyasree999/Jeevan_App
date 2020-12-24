package com.cg.jeevanonlineterminsurance.exception;
/*
 * Payment Validations
 * @author - Divya
 */
import java.util.regex.*;
public class PaymentValidator {
	public boolean validatePaymentId(Integer paymentId)throws PaymentIdNotFoundException {
		String regex="^[0-9]{7}*$";
		Pattern pat=Pattern.compile(regex);
		Matcher m=null;
		try {
		 m = pat.matcher(String.valueOf(paymentId));
		}catch(NumberFormatException e) {
			//throw new PaymentIdNotFoundException("enter a valid Id");
			}
		return m.matches();
	}
}
