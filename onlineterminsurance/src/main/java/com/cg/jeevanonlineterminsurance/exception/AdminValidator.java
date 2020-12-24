package com.cg.jeevanonlineterminsurance.exception;
/*
 * Customer Validations
 * @author - Poorani
 */
import java.util.regex.*;
public class AdminValidator {
	/*Admin admin=new Admin(); 
	  public boolean validCheck(Admin admin) { 
	  //Pattern pattern=pattern.compile(); 
	  Integer id=admin.getAdminPolicyId(); 
	  String adminPolicyId=id.toString(); 
	  Integer uid=admin.getAdminId(); 
	  String policyId=pid.toString(); 
	  Integer pid=admin.getPolicyId(); 
	  String policyId=pid.toString();
	  String adminName=admin.getAdminName(); 
	  String email=admin.getEmail(); 
	  String mobileNo=admin.getMobileNo(); Integer a=admin.getAge(); 
	  String age=a.toString(); 
	  String dob=admin.getDob();
	  boolean up=Pattern.matches("[0-9]{8}",adminPolicyId); 
	  boolean u=Pattern.matches("[0-9]{8}", adminId); 
	  boolean p=Pattern.matches("[0-9]{8}", policyId); 
	  boolean str1=Pattern.matches("[a-zA-Z]{3,}", adminName); 
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
	public boolean validateAdminId(Integer adminId)throws ResourceNotFoundException {
		String regex="^[0-9]{8}*$";
		Pattern pat=Pattern.compile(regex);
		Matcher m=null;
		try {
		 m = pat.matcher(String.valueOf(adminId));
		}catch(NumberFormatException e) {
			//throw new ResourceNotFoundException("enter a valid Id");
			}
		return m.matches();
	}
}
