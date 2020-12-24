package com.cg.jeevanonlineterminsurance.exception;
/** The PaymentIdNotFoundException layer provides customized Exceptions
 * 
 * @author Divya
 * 
 * 
 */
public class PaymentIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "Payment with this Id is not found.";

	public PaymentIdNotFoundException(final String MESSAGE) {
		super(MESSAGE);
	}
}
