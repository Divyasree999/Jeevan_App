package com.cg.jeevanonlineterminsurance.service;
/** This is an interface which defines CRUD methods for Payment service
 * 
 * @author - Divya
 *
 */
import java.util.List;
import com.cg.jeevanonlineterminsurance.entity.Payment;
import com.cg.jeevanonlineterminsurance.exception.PaymentIdNotFoundException;
public interface PaymentService {
	public Payment savePayment(Payment payment) throws PaymentIdNotFoundException;

	public Payment updatePayment(Integer paymentId, Payment payment) throws PaymentIdNotFoundException;

	public Payment findPaymentById(Integer paymentId) throws PaymentIdNotFoundException;

	public List<Payment> getAllPayments();
}
