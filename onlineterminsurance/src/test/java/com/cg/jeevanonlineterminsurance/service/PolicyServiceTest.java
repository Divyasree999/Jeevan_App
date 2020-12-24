package com.cg.jeevanonlineterminsurance.service;
/*
 * Service test cases
 * @author - Chaithanya
 */
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.jeevanonlineterminsurance.entity.Policy;
import com.cg.jeevanonlineterminsurance.repository.PolicyDaoImpl;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
class PolicyServiceTest {
	@MockBean
	 private PolicyDaoImpl policyDaoImpl;
	
	 @Autowired
	 private PolicyService policyService;
	 
	 /*
		 * Test 
		 * assertThat to checks if a specific value match to expected one
		 */
	
	 @Test
	  void testGetPolicyById() throws Exception{
		    Policy policy=new Policy();
	        policy.setCustomerId(101);
		    policy.setPolicyId(401);
		    policy.setRegisteredDate("2000-11-10");
	        policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);


	      Mockito.when(policyDaoImpl.findByPolicyId(101)).thenReturn(policy);
	    		  //findPolicyById()).get()).thenReturn(policy);
	        		//Mockito.when(policyDaoImpl.findById(policy.getpolicyid()).get()).thenReturn(policy);
		        assertThat(policyService.findPolicyById(101)).isEqualTo(policy);
		    }
	 /*
		 * 
		 * assertTrue to check if the condition is true
		 */


	@Test
	void testDeletePolicy() throws Exception {
		    Policy policy=new Policy();
	        policy.setCustomerId(100);
		    policy.setPolicyId(401);
		    policy.setRegisteredDate("2000-11-10");
	        policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);
		policyDaoImpl.deleteById(policy.getPolicyId());
       System.out.println(policyDaoImpl.findById(100));
       Assert.assertTrue(policyDaoImpl.findById(100).isEmpty());
	}
	
	/*
	 * 
	 * returns the value when mocked object is called
	 */

	@Test
	void testUpdatePolicyById() throws Exception {
		    Policy policy=new Policy();
	        policy.setCustomerId(101);
		    policy.setPolicyId(401);
		    policy.setRegisteredDate("2000-11-10");
	        policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);


		        Mockito.when(policyDaoImpl.findByPolicyId(101)).thenReturn(policy);
		        policy.setAmount(80000.00);
		        Mockito.when(policyDaoImpl.save(policy)).thenReturn(policy);
		        System.out.println(policy.getAmount());
		       // assertThat(policyPolicyService.updatePolicy(101, policy)).isEqualTo(policy);
	}
	
	/*
	 * 
	 * assertThat to checks if a specific value match to expected one
	 */

	@Test
	void testGetAllUserPolicies() {
		    Policy policy=new Policy();
	        policy.setCustomerId(101);
		    policy.setPolicyId(401);
		    policy.setRegisteredDate("2000-11-10");
	        policy.setTotalTime(12);
	        policy.setAmount(60000.00);
	        policy.setMonthOver(2);
	        policy.setAmountPaid(5000.00);


	        Policy policy1=new Policy();
	        policy1.setCustomerId(103);
		    policy1.setPolicyId(401);
		    policy1.setRegisteredDate("2000-11-10");
	        policy1.setTotalTime(12);
	        policy1.setAmount(60000.00);
	        policy1.setMonthOver(2);
	        policy1.setAmountPaid(5000.00);

       List<Policy> policyList = new ArrayList<>();
       policyList.add(policy);
       policyList.add(policy1);

       Mockito.when(policyDaoImpl.findAll()).thenReturn(policyList);
       assertThat(policyService.getAllPolicies()).isEqualTo(policyList);
	}

	@Test
	void testSavePolicy() {
		Policy policy=new Policy();
		policy.setCustomerId(108);
	    policy.setPolicyId(401);
	    policy.setRegisteredDate("2000-11-10");
       policy.setTotalTime(12);
       policy.setAmount(60000.00);
       policy.setMonthOver(2);
       policy.setAmountPaid(5000.00);
		
	}
}
