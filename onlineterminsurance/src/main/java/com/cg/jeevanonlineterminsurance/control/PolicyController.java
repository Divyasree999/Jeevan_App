package com.cg.jeevanonlineterminsurance.control;
/*
 * Implementation Of controller layer
 * @author - Chaithanya
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.jeevanonlineterminsurance.entity.Policy;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
import com.cg.jeevanonlineterminsurance.service.PolicyService;

@RestController
@RequestMapping("/api/v2")
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	
	/*
	  *get the list of policies
	  */

	@GetMapping("/getallpolicies")
	public List<Policy> getAllPolicies() {
		return policyService.getAllPolicies();
	}
	
	/*
	  *find policy details based on policyId
	  */

	@GetMapping("/findpolicy/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable(value = "id") Integer policyid) throws ResourceNotFoundException {
		Policy policy= policyService.findPolicyById(policyid);
		return  ResponseEntity.ok(policy);
	}
	
	/*
	  * create policy details based on policyId
	  */
	@PostMapping("/savepolicy")
	public Policy createPolicy( @RequestBody Policy policy ) {
		return policyService.savePolicy(policy);
	}
	
	 /*
	  * updating policy details based on policyId
	  */

	@PutMapping("/updatepolicy/{id}")
	public ResponseEntity<Policy> updatePolicyById(@PathVariable(value = "id") Integer PolicyId,
			 @RequestBody Policy policy) throws ResourceNotFoundException {
		Policy policy1= policyService.updatePolicy(PolicyId, policy);
		return  ResponseEntity.ok(policy1);
	}
	
	 /*
	  * delete policy details based on policyId
	  */
	
	 @DeleteMapping("/deletepolicy/{id}")
	 public ResponseEntity<Boolean> deletePolicy(@PathVariable(value = "id") Integer PolicyId,@RequestBody Policy policy) throws ResourceNotFoundException	{
			Boolean policy1 = policyService.deletePolicyById(PolicyId);
			return  ResponseEntity.ok(policy1);
    }
}
