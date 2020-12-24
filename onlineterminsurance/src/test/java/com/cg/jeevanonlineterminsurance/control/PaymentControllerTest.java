package com.cg.jeevanonlineterminsurance.control;
/** The PaymentControllerTest class provides testing of PaymentController layer
 *   
 * @author - Divya
 * 
 */
import com.cg.jeevanonlineterminsurance.entity.Payment;
import com.cg.jeevanonlineterminsurance.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PaymentController.class)
public class PaymentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PaymentService paymentService;
    //This method is used to add payment
	@Test
	public void testCreatePayment() throws Exception {
		String URI = "/api/v2/savepayment";
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);

		String jsonInput = this.converttoJson(payment);

		Mockito.when(paymentService.savePayment(Mockito.any(Payment.class))).thenReturn(payment);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	//This method is used to update the payment details
	@Test
	public void testUpdatePayment() throws Exception {
		String URI = "/api/v2/updatepayment/{id}";
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);
		String jsonInput = this.converttoJson(payment);

		Mockito.when(paymentService.updatePayment(Mockito.any(), Mockito.any())).thenReturn(payment);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 102345)
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	//This method is used to get the payment detail based on paymentId
	@Test
	public void testGetPaymentById() throws Exception {
		String URI = "/api/v2/findpayment/{id}";
		Payment payment = new Payment();
		payment.setPaymentId(102221);
		payment.setType("Credit");
		payment.setStatus("Success");
		payment.setCardName("Aravind");
		payment.setCardNumber("9895 2114 9993 9321");
		payment.setCardExpiry("07/2027");
		payment.setCvv(943);

		String jsonInput = this.converttoJson(payment);

		Mockito.when(paymentService.findPaymentById(Mockito.any())).thenReturn(payment);
		// Assert.assertTrue(paymentService.findPaymentById());
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 102221).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	//This method is used to get all the payment details
	@Test
	public void testGetAllPayments() throws Exception {
		String URI = "/api/v2/getAllPayments";
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);

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
		payment5.setPaymentId(123477);
		payment5.setType("Debit");
		payment5.setStatus("Success");
		payment5.setCardName("Divya");
		payment5.setCardNumber("0084 4783 0389 6214");
		payment5.setCardExpiry("08/2022");
		payment5.setCvv(396);
		List<Payment> paymentList = new ArrayList<>();
		paymentList.add(payment);
		paymentList.add(payment1);
		paymentList.add(payment2);
		paymentList.add(payment3);
		paymentList.add(payment4);
		paymentList.add(payment5);
		String jsonInput = this.converttoJson(paymentList);

		Mockito.when(paymentService.getAllPayments()).thenReturn(paymentList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object payment) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(payment);
	}
}
