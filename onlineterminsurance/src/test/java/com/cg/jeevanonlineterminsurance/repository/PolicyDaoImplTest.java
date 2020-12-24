package com.cg.jeevanonlineterminsurance.repository;
/*
 * DaoImpl test cases
 * @author - Chaithanya
 */
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.jeevanonlineterminsurance.entity.Policy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class PolicyDaoImplTest {
	@Autowired
	private PolicyDaoImpl policyDaoImpl;
	@Autowired
	private TestEntityManager testEntityManager;
	
	/*
	 * 
	 * assertThat to checks if a specific value match to expected one
	 */
	@Test
	void testNewPolicy() throws Exception{
		Policy policy=getPolicy();
		Policy saveInDb=testEntityManager.persist(policy);
		Policy getFromInDb=policyDaoImpl.findById(saveInDb.getPolicyId()).get();
				assertThat(getFromInDb).isEqualTo(saveInDb);
}
	private Policy getPolicy() {
		Policy policy=new Policy();
	    policy.setCustomerId(101);
	    policy.setPolicyId(401);
	    policy.setRegisteredDate("2000-11-10");
        policy.setTotalTime(12);
        policy.setAmount(60000.00);
        policy.setMonthOver(2);
        policy.setAmountPaid(5000.00);
		return policy;
	}
	
	/*
	 * 
	 * assertThat to checks if a specific value match to expected one
	 */
	@Test
	 void testGetPolicyById() throws Exception{
		Policy policy=new Policy();
		policy.setCustomerId(102);
		policy.setPolicyId(402);
		policy.setRegisteredDate("2000-11-10");
		policy.setTotalTime(24);
		policy.setAmount(80000.00);
		policy.setMonthOver(4);
		policy.setAmountPaid(7000.00);
        Policy saveInDb=testEntityManager.persist(policy);
        Policy getInDb=policyDaoImpl.findById(policy.getPolicyId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	
	/*
	 * 
	 * assertEquals to check if two objects are equally defined or not
	 */
	
	@Test
	 void testGetAllPolicies() throws Exception{
		Policy policy1=new Policy();
	    policy1.setCustomerId(105);
	    policy1.setPolicyId(402);
	    policy1.setRegisteredDate("2000-11-10");
        policy1.setTotalTime(24);
        policy1.setAmount(80000.00);
        policy1.setMonthOver(4);
        policy1.setAmountPaid(7000.00);
        testEntityManager.persist(policy1);
        List<Policy> policyList=(List<Policy>) policyDaoImpl.findAll();
        assertEquals(1, policyList.size());
        
	}
	/*
	 * 
	 * assertEquals to check if two objects are equally defined or not
	 */
	
	
	@Test
	 void testDeletePolicyById() throws Exception{
		Policy policy1=new Policy();
	    policy1.setCustomerId(105);
	    policy1.setPolicyId(402);
	    policy1.setRegisteredDate("2000-11-10");
        policy1.setTotalTime(24);
        policy1.setAmount(80000.00);
        policy1.setMonthOver(4);
        policy1.setAmountPaid(7000.00);
        Policy policy3=testEntityManager.persist(policy1);
        testEntityManager.remove(policy3);
        List<Policy> policies=(List<Policy>) policyDaoImpl.findAll();
        assertEquals(0,policies.size());
        
	}
	
	/*
	 * 
	 * assertThat to checks if a specific value match to expected one
	 */
	@Test
	 void testUpdatePolicy() {
		Policy policy=new Policy();
		policy.setCustomerId(108);
		policy.setPolicyId(402);
		policy.setRegisteredDate("2000-11-10");
		policy.setTotalTime(24);
		policy.setAmount(80000.00);
		policy.setMonthOver(4);
		policy.setAmountPaid(7000.00);
        testEntityManager.persist(policy);
        Policy getFromDb=policyDaoImpl.findById(policy.getPolicyId()).get();
        getFromDb.setAmount(100000.00);
        testEntityManager.persist(getFromDb);
        assertThat(getFromDb.getAmount()).isEqualTo(100000.00);
	}
}
