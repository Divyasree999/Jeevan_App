package com.cg.jeevanonlineterminsurance.exception;
/*
 * Customer Validations
 * @author - Shahanaz
 */
import java.util.regex.*;
public class CustomerValidator {
	/*Customer customer=new Customer(); 
	  public boolean validCheck(Customer customer) { 
	  //Pattern pattern=pattern.compile(); 
	  Integer id=customer.getCustomerPolicyId(); 
	  String customerPolicyId=id.toString(); 
	  Integer uid=customer.getCustomerId(); 
	  String policyId=pid.toString(); 
	  Integer pid=customer.getPolicyId(); 
	  String policyId=pid.toString();
	  String customerName=customer.getCustomerName(); 
	  String email=customer.getEmail(); 
	  String mobileNo=customer.getMobileNo(); Integer a=customer.getAge(); 
	  String age=a.toString(); 
	  String dob=customer.getDob();
	  boolean up=Pattern.matches("[0-9]{8}",customerPolicyId); 
	  boolean u=Pattern.matches("[0-9]{8}", customerId); 
	  boolean p=Pattern.matches("[0-9]{8}", policyId); 
	  boolean str1=Pattern.matches("[a-zA-Z]{3,}", customerName); 
	  boolean str2=Pattern.matches("/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/", email); 
	  boolean str3=Pattern.matches("[0-9]{10}", mobileNo); 
	  boolean str4=Pattern.matches("[0-9]{2}", age); 
	  boolean str5=Pattern.matches("/^([0-9]{2})-([0-9]{2})-([0-9]{4})$/", dob); 
	  boolean value=false;
	  if(up==true && p==true && p==true && str1==true && str2==true && str3==true && str4==true && str5==true) {
	       return true;
	  }else{
	       return false;
	  }*/
	public boolean validateCustomerId(Integer customerId)throws ResourceNotFoundException {
		String regex="^[0-9]{8}*$";
		Pattern pat=Pattern.compile(regex);
		Matcher m=null;
		try {
		 m = pat.matcher(String.valueOf(customerId));
		}catch(NumberFormatException e) {
			//throw new ResourceNotFoundException("enter a valid Id");
			}
		return m.matches();
	}
}
