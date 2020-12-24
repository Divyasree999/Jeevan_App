package com.cg.jeevanonlineterminsurance.control;
/*
 * Implementation Of controller layer
 * @author - Shahanaz
 */
import java.util.List;


//import javax.validation.Valid;

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

import com.cg.jeevanonlineterminsurance.entity.Customer;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
import com.cg.jeevanonlineterminsurance.service.CustomerService;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
    // get all customer details
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
    // get customer details based on customerId
	@GetMapping("/findcustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Integer customerId) throws ResourceNotFoundException {
		Customer customer= customerService.findCustomerById(customerId);
		return  ResponseEntity.ok(customer);
	}
	// add a customer
	@PostMapping("/savecustomer")
	public Customer createCustomer( @RequestBody Customer customer ) {
		return customerService.saveCustomer(customer);
	}
    // updating customer details based on customerId
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable(value = "id") Integer customerId,
			 @RequestBody Customer customer) throws ResourceNotFoundException {
		Customer customer1= customerService.updateCustomer(customerId, customer);
		return  ResponseEntity.ok(customer1);
	}
    // removing customer based on customerId
	 @DeleteMapping("/deletecustomer/{id}")
	 public ResponseEntity<Boolean> deleteCustomer(@PathVariable(value = "id") Integer customerId,@RequestBody Customer customer) throws ResourceNotFoundException	{
			Boolean customer1 = customerService.deleteCustomerById(customerId);
			return  ResponseEntity.ok(customer1);
    }
}
