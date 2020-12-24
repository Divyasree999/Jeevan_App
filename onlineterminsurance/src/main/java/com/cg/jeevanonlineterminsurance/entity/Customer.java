package com.cg.jeevanonlineterminsurance.entity;
/*
 * Implementation Of entity table
 * @author - Shahanaz
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@OneToMany
	//@JoinColumn(name="policy_Id")
	private int customerPolicyId;
	private int customerId;
	private int policyId;
	private String customerName;
	private String email;
	private String mobileNo;
	private int age;
	private String dob;

	public Customer() {
		super();
	}

	public Customer(int customerId, int policyId, String customerName, String email, String mobileNo, int age,
			String dob) {
		super();
		// this.customerPolicyId = customerPolicyId;
		this.customerId = customerId;
		this.policyId = policyId;
		this.customerName = customerName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.age = age;
		this.dob = dob;
	}

	// @Column(name = "customer_policy_id", nullable = false)
	public int getCustomerPolicyId() {
		return customerPolicyId;
	}

	public void setCustomerPolicyId(int customerPolicyId) {
		this.customerPolicyId = customerPolicyId;
	}

	// @Column(name = "customer_id", nullable = false)
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	// @Column(name = "policy_id", nullable = false)
	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	// @Column(name = "customer_name", nullable = false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// @Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// @Column(name = "mobile_No", nullable = false)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	// @Column(name = "age", nullable = false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// @Column(name = "dob", nullable = false)
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Customer [customerPolicyId=" + customerPolicyId + ", customerId=" + customerId + ", policyId="
				+ policyId + ", customerName=" + customerName + ", email=" + email + ", mobileNo=" + mobileNo + ", age="
				+ age + ", dob=" + dob + "]";
	}

}
