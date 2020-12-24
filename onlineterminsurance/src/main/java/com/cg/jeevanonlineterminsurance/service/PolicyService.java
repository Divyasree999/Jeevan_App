package com.cg.jeevanonlineterminsurance.service;
import java.util.List;
import com.cg.jeevanonlineterminsurance.entity.Policy;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
/** This class elaborates on service interface
* 
* @author Chaithanya
* 
*/
public interface PolicyService {
    /**This method is to add policy*/
	/**This method is to get all the policies of one particular user */	
	public List<Policy> getAllPolicies();
	public Policy findPolicyById(Integer policyId) throws ResourceNotFoundException;
	public Policy savePolicy(Policy policy);
	public Policy updatePolicy(Integer policyId, Policy policy) throws ResourceNotFoundException;
	public boolean deletePolicyById(Integer policyId) throws ResourceNotFoundException;
}
