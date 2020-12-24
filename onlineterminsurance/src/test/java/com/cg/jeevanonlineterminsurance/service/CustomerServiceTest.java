package com.cg.jeevanonlineterminsurance.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeevanonlineterminsurance.entity.Customer;
import com.cg.jeevanonlineterminsurance.repository.CustomerDaoImpl;
import static org.assertj.core.api.Assertions.assertThat;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerServiceTest {
	@MockBean
	private CustomerDaoImpl customerDaoImpl;

	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetCustomerById() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(10178263);
		customer.setPolicyId(40127382);
		customer.setCustomerName("Hema");
		customer.setEmail("hema26@gmail.com");
		customer.setMobileNo("7845326170");
		customer.setAge(27);
		customer.setDob("16-07-1993");

		Mockito.when(customerDaoImpl.findByCustomerId(10178278)).thenReturn(customer);
		// findCustomerById()).get()).thenReturn(customer);
		// Mockito.when(customerDaoImpl.findById(customer.getCustomerId()).get()).thenReturn(customer);
		assertThat(customerService.findCustomerById(10178278)).isEqualTo(customer);
	}

	@Test
	void testDeleteCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(10178274);
		customer.setPolicyId(401273827);
		customer.setCustomerName("Sanya");
		customer.setEmail("sanya123@gmail.com");
		customer.setMobileNo("7893436347");
		customer.setAge(25);
		customer.setDob("13-08-1996");
		customerDaoImpl.deleteById(customer.getCustomerId());
		System.out.println(customerDaoImpl.findById(10178274));
		assertThat(customerDaoImpl.findById(10178274).isEmpty());
	}

	@Test
	void testUpdateCustomerById() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerId(10178263);
		customer.setPolicyId(40127382);
		customer.setCustomerName("Hema");
		customer.setEmail("hema26@gmail.com");
		customer.setMobileNo("7845326170");
		customer.setAge(27);
		customer.setDob("16-07-1993");

		Mockito.when(customerDaoImpl.findByCustomerId(10178278)).thenReturn(customer);
		customer.setMobileNo("6543874051");
		Mockito.when(customerDaoImpl.save(customer)).thenReturn(customer);
		System.out.println(customer.getMobileNo());
		// assertThat(customerPolicyService.updateCustomer(10178263,
		// customer)).isEqualTo(customer);
	}

	@Test
	void testGetAllCustomerPolicies() {
		Customer customer = new Customer();
		customer.setCustomerId(10178263);
		customer.setPolicyId(40127382);
		customer.setCustomerName("Hema");
		customer.setEmail("hema26@gmail.com");
		customer.setMobileNo("7845326170");
		customer.setAge(27);
		customer.setDob("16-07-1993");

		Customer customer1 = new Customer();
		customer1.setCustomerId(10178254);
		customer1.setPolicyId(40127672);
		customer1.setCustomerName("Manyatha");
		customer1.setEmail("manyatha453@gmail.com");
		customer1.setMobileNo("7487589312");
		customer1.setAge(24);
		customer1.setDob("12-09-1997");
		Customer customer2 = new Customer();
		customer2.setCustomerId(12098254);
		customer2.setPolicyId(34527672);
		customer2.setCustomerName("Divya");
		customer2.setEmail("divya453@gmail.com");
		customer2.setMobileNo("8008321312");
		customer2.setAge(21);
		customer2.setDob("12-07-1999");
		Customer customer3 = new Customer();
		customer3.setCustomerId(12278263);
		customer3.setPolicyId(42227382);
		customer3.setCustomerName("Nanda");
		customer3.setEmail("nanda26@gmail.com");
		customer3.setMobileNo("6678326170");
		customer3.setAge(27);
		customer3.setDob("13-07-1993");
		Customer customer4 = new Customer();
		customer4.setCustomerId(10078263);
		customer4.setPolicyId(40227382);
		customer4.setCustomerName("Nandu");
		customer4.setEmail("nandu26@gmail.com");
		customer4.setMobileNo("6678326170");
		customer4.setAge(27);
		customer4.setDob("13-06-1993");
		
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer);
		customerList.add(customer1);
		customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
		Mockito.when(customerDaoImpl.findAll()).thenReturn(customerList);
		assertThat(customerService.getAllCustomers()).isEqualTo(customerList);
	}

	@Test
	void testSaveCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId(10878781);
		customer.setPolicyId(40255512);
		customer.setCustomerName("Sharad Malhotra");
		customer.setEmail("malhotrasharad21@gmail.com");
		customer.setMobileNo("8989891212");
		customer.setAge(25);
		customer.setDob("21-12-1995");

	}
}
