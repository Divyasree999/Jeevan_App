package com.cg.jeevanonlineterminsurance.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author Chaithanya
 * Creates a table with name policy in the database.
 *
 */
@Entity
@Table(name="policy")
public class Policy {
	/**
	 * Attributes
	 */
	@Id
	//@ManyToOne
	//@JoinColumn(name = "customer_Id")
	//@JoinColumn(name = "payment_Id")
	//@JoinColumn(name = "admin_Id")
	private int policyId;
	private int customerId;
	private String registeredDate;	
	private double amount;	
	private int totalTime;	
	private int monthOver;	
	private double amountPaid;	
	public Policy() {
		super();
	}
	
	public Policy(int customerId, int policyId,String registeredDate, double amount, int totalTime,
			int monthOver, double amountPaid) {
		super();
		
		this.customerId = customerId;
		this.policyId = policyId;
		this.registeredDate = registeredDate;
		this.amount = amount;
		this.totalTime = totalTime;
		this.monthOver = monthOver;
		this.amountPaid = amountPaid;
	}
	
	/*
	  *getters and setters implementation
	  */

	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	public String getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(String registeredDate) {
		this.registeredDate = registeredDate;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public int getMonthOver() {
		return monthOver;
	}
	public void setMonthOver(int monthOver) {
		this.monthOver = monthOver;
	}
	
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	/*
	  *return the specific values of objects not hashcode of objects
	  */

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", customerId=" + customerId
				+ ", registeredDate=" + registeredDate + ", amount=" + amount + ", totalTime=" + totalTime
				+ ", monthOver=" + monthOver + ", amountPaid=" + amountPaid + "]";
	}
}
