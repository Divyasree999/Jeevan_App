package com.cg.jeevanonlineterminsurance.control;
/*
 * @author - Divya
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.jeevanonlineterminsurance.entity.Payment;
import com.cg.jeevanonlineterminsurance.exception.PaymentIdNotFoundException;
import com.cg.jeevanonlineterminsurance.service.PaymentService;

@RestController
@RequestMapping("/api/v2")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	//add payment details
	@PostMapping("/savepayment")
	public Payment savePayment( @RequestBody Payment payment ) throws PaymentIdNotFoundException{
		return paymentService.savePayment(payment);
	}
    // update the payment details
	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<Payment> updatePaymentById(@PathVariable(value = "id") Integer paymentId,
			 @RequestBody Payment payment) throws PaymentIdNotFoundException {
		Payment payment1= paymentService.updatePayment(paymentId, payment);
		return  ResponseEntity.ok(payment1);
	}
    // find the payment details by paymentId
	@GetMapping("/findpayment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Integer paymentId) throws PaymentIdNotFoundException {
		Payment payment= paymentService.findPaymentById(paymentId);
		return  ResponseEntity.ok(payment);
	}
	//get all the payment details
	@GetMapping("/getAllPayments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}
}
