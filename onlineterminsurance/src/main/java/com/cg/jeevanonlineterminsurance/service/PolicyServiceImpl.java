package com.cg.jeevanonlineterminsurance.service;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.jeevanonlineterminsurance.entity.Policy;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
import com.cg.jeevanonlineterminsurance.repository.PolicyDaoImpl;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService{
	@Autowired
	private PolicyDaoImpl policy;
	
	
	//------------------------ 1. TermInsurance Application --------------------------
	/*******************************************************************************************************
	 - Function Name	: getAllPolicy()	
	 - Return Type		: list
	 - Throws		    : ResourceNotFoundException
	 - Author	      	: Chaithanya 
	 - Creation Date	: 7/12/2020
	 - Description		: calls method getAllPolicies()
	 ********************************************************************************************************/

	public List<Policy> getAllPolicies(){
		return policy.findAll();
	}
	
	//------------------------ 1. TermInsurance Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	findPolicyById
	 - Return Type		:	policy object
	 - Throws		    :  	ResourceNotFoundException
	 - Author		    :	Chaithanya
	 - Creation Date	:	calls method  findPolicyById(policyId)
	 ********************************************************************************************************/

	public Policy findPolicyById(@PathVariable(value="id")Integer policyId) throws ResourceNotFoundException {
	
		Policy p =policy.findByPolicyId(policyId);
		if(p==null)
		{
			new ResourceNotFoundException("Policy not found for this id :: " +policyId);
		}
		return p;
	}
	
	//------------------------ 1. TermInsurance Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	deletePolicy
	 - Input Parameters	:	String PolicyId
	 - Return Type		:	policy object
	 - Throws		    :  	ResourceNotFoundException
	 - Author		    :	Chaithanya
	 - Creation Date	:	7/12/2020
	 - Description		:	calls method  deletePolicy(Integer policyId)
	 ********************************************************************************************************/

   
    public boolean deletePolicyById(Integer policyId) throws ResourceNotFoundException {
    	Policy p = policy.findById(policyId)
				.orElseThrow(() -> new ResourceNotFoundException("User Policy ot found for this id :: " + policyId));
    	 policy.delete(p);
    	 if(p==null){
	            return true;
	        }
	        return false;
    }
	
  //------------------------ 1. TermInsurance Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	savePolicy
	 - Return Type		:	policy object
	 - Author		    :	Chaithanya
	 - Creation Date	:	7/12/2020
	 - Description		:	calls method savePolicy(Policy p)
	 ********************************************************************************************************/


	public Policy savePolicy(Policy p) {
		
		return policy.save(p);
	}
	
	//------------------------ 1. TermInsurance Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	updatePolicy
			 - Return Type		:	policy object
			 - Throws		    :  	ResourceNotFoundException
			 - Author		    :	Chaithanya
			 - Creation Date	:	7/12/2020
			 - Description		:	calls method  updatePolicy(Policy p)
			 ********************************************************************************************************/


	public Policy updatePolicy(Integer policyId,Policy p) throws ResourceNotFoundException {
		Policy p1= policy.findById(policyId)
				.orElseThrow(() -> new ResourceNotFoundException("User Policy not found for this id :: " + policyId));
	    p1.setCustomerId(p.getCustomerId());
		p1.setPolicyId(p.getPolicyId());
		p1.setRegisteredDate(p.getRegisteredDate());
		p1.setAmount(p.getAmount());
		p1.setTotalTime(p.getTotalTime());
		p1.setMonthOver(p.getMonthOver());
		p1.setAmountPaid(p.getAmountPaid());
		final Policy updatedPolicy = policy.save(p1);
		return updatedPolicy;
	}
	public List<Policy> saveAll(){
		return null;
	}

}
