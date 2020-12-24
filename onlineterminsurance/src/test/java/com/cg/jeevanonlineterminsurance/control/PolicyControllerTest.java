package com.cg.jeevanonlineterminsurance.control;
/*
 * Controller test cases
 * @author - Chaithanya
 */
import com.cg.jeevanonlineterminsurance.entity.Policy;
import com.cg.jeevanonlineterminsurance.service.PolicyService;
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
@WebMvcTest(value = PolicyController.class)
public class PolicyControllerTest {
	@Autowired
    private MockMvc mockMvc;
 @MockBean
    private PolicyService policyService;

 @Test
	public void testCreateCustomerPolicy() throws Exception{
	        String URI = "/api/v2/savepolicy";
	        Policy policy = new Policy();
	        policy.setPolicyId(101);
	        policy.setCustomerId(401);
	        policy.setRegisteredDate("2000-09-08");
	        policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);

	        String jsonInput = this.converttoJson(policy);

	        Mockito.when(policyService.savePolicy(Mockito.any(Policy.class))).thenReturn(policy);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
 }
 @Test
	public void testGetCustomerPolicyById() throws Exception {
		String URI= "/api/v2/findpolicy/{id}";
		Policy policy = new Policy();
		policy.setCustomerId(102);
		policy.setPolicyId(401);
		policy.setRegisteredDate("2000-11-10");
		policy.setTotalTime(12);
		policy.setAmount(60000.00);
		policy.setMonthOver(2);
		policy.setAmountPaid(5000.00);
        
        String jsonInput = this.converttoJson(policy);

       Mockito.when(policyService.findPolicyById(Mockito.any())).thenReturn(policy);
        //Assert.assertTrue(userpolicyService.findCustomerPolicyById());
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 401).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
 @Test
	public void testUpdateCustomerPolicy() throws Exception {
		String URI = "/api/v2/updatepolicy/{id}";
		Policy policy = new Policy();
		policy.setCustomerId(105);
		policy.setPolicyId(401);
		policy.setRegisteredDate("2000-11-10");
		policy.setTotalTime(12);
		policy.setAmount(60000.00);
		policy.setMonthOver(2);
		policy.setAmountPaid(5000.00);
        String jsonInput = this.converttoJson(policy);

        Mockito.when(policyService.updatePolicy(Mockito.any(),Mockito.any())).thenReturn(policy);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
 @Test
	public void testDeleteCustomerPolicy() throws Exception {
		String URI = "/api/v2/deletepolicy/{id}";
		Policy policy = new Policy();
		policy.setCustomerId(105);
		policy.setPolicyId(401);
		policy.setRegisteredDate("2000-11-08");
		policy.setTotalTime(12);
		policy.setAmount(60000.00);
		policy.setMonthOver(2);
		policy.setAmountPaid(5000.00);

        Mockito.when(policyService.findPolicyById(Mockito.any())).thenReturn(policy);
        Mockito.when(policyService.deletePolicyById(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
 @Test
	public void testGetAllPolicies() throws Exception {
		String URI = "/api/v2/getallpolicies";
		Policy policy = new Policy();
		policy.setCustomerId(105);
		 policy.setPolicyId(401);
		    policy.setRegisteredDate("2000-11-10");
		    policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);
	        
	        Policy policy1 = new Policy();
			 policy1.setCustomerId(105);
			    policy1.setPolicyId(401);
			    policy1.setRegisteredDate("2000-11-10");
		        policy1.setTotalTime(12);
		        policy1.setAmount(60000.00);
		        policy1.setMonthOver(2);
		        policy1.setAmountPaid(5000.00);
	    	 List<Policy> policyList=new ArrayList<>();
	    	  policyList.add(policy);
	    	policyList.add(policy);
	    	 
	    	String jsonInput = this.converttoJson(policyList);

	         Mockito.when(policyService.getAllPolicies()).thenReturn(policyList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	private String converttoJson(Object policy) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(policy);
	}
}
