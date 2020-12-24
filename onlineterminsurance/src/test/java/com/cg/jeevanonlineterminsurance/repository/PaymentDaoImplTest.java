package com.cg.jeevanonlineterminsurance.repository;
/** The PaymentDaoImplTest class provides testing of PaymentDaoImpl layer
 *   
 * @author - Divya
 * 
 */
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.jeevanonlineterminsurance.entity.Payment;
import com.cg.jeevanonlineterminsurance.exception.PaymentIdNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PaymentDaoImplTest {
	@Autowired
	private PaymentDaoImpl paymentDaoImpl;
	@Autowired
	private TestEntityManager testEntityManager;
	//This method is used to add payment
	@Test
	public void testNewPayment() throws PaymentIdNotFoundException {
		Payment payment = getPayment();
		Payment saveInDb = testEntityManager.persist(payment);
		Payment getInDb = paymentDaoImpl.findById(payment.getPaymentId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}
	private Payment getPayment() {
		Payment payment = new Payment();
		payment.setPaymentId(101143);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Ramya");
		payment.setCardNumber("8321 9325 0802 2345");
		payment.setCardExpiry("10/2034");
		payment.setCvv(900);
		return payment;
	}
	//This method is used to update payment details
	@Test
	public void testUpdatePayment() throws PaymentIdNotFoundException{
		Payment payment = new Payment();
		payment.setPaymentId(12835);
		payment.setType("Credit");
		payment.setStatus("Failed");
		payment.setCardName("sandhya");
		payment.setCardNumber("7235 0094 3143 9250");
		payment.setCardExpiry("09/2033");
		payment.setCvv(804);
		testEntityManager.persist(payment);
		Payment getFromDb = paymentDaoImpl.findById(payment.getPaymentId()).get();
		getFromDb.setStatus("Success");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getStatus()).isEqualTo("Success");
	}
	//This method is used to get the payment detail based on PaymentId
	@Test
	public void testGetPaymentById() throws PaymentIdNotFoundException {
		Payment payment = new Payment();
		payment.setPaymentId(102221);
		payment.setType("Credit");
		payment.setStatus("Success");
		payment.setCardName("Aravind");
		payment.setCardNumber("9895 2114 9993 9321");
		payment.setCardExpiry("07/2027");
		payment.setCvv(943);
		Payment saveInDb = testEntityManager.persist(payment);
		Payment getInDb = paymentDaoImpl.findById(payment.getPaymentId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}
    //This method is used to get all the payment details
	@Test
	public void testGetAllPayments()  throws Exception{
		Payment payment1 = new Payment();
		payment1.setPaymentId(102345);
		payment1.setType("Debit");
		payment1.setStatus("Success");
		payment1.setCardName("Girija");
		payment1.setCardNumber("6565 1234 5453 7771");
		payment1.setCardExpiry("02/2022");
		payment1.setCvv(123);
		Payment payment2 = new Payment();
		payment2.setPaymentId(102222);
		payment2.setType("Credit");
		payment2.setStatus("Failed");
		payment2.setCardName("Sravya");
		payment2.setCardNumber("0134 4354 6935 2734");
		payment2.setCardExpiry("11/2040");
		payment2.setCvv(331);
		Payment payment3 = new Payment();
		payment3.setPaymentId(102277);
		payment3.setType("Credit");
		payment3.setStatus("Failed");
		payment3.setCardName("Sravani");
		payment3.setCardNumber("1124 4054 0935 2234");
		payment3.setCardExpiry("07/2032");
		payment3.setCvv(326);
		Payment payment4 = new Payment();
		payment4.setPaymentId(123477);
		payment4.setType("Debit");
		payment4.setStatus("Success");
		payment4.setCardName("Divya");
		payment4.setCardNumber("0084 4783 0389 6214");
		payment4.setCardExpiry("08/2022");
		payment4.setCvv(396);
		Payment payment5 = new Payment();
		payment5.setPaymentId(671227);
		payment5.setType("Debit");
		payment5.setStatus("Success");
		payment5.setCardName("Ramya");
		payment5.setCardNumber("1094 4233 0389 6214");
		payment5.setCardExpiry("08/2024");
		payment5.setCvv(111);
		testEntityManager.persist(payment1);
		testEntityManager.persist(payment2);
		testEntityManager.persist(payment3);
		testEntityManager.persist(payment4);
		testEntityManager.persist(payment5);
		List<Payment> paymentList = (List<Payment>) paymentDaoImpl.findAll();
		assertEquals(5, paymentList.size());

	}
}
