package com.cg.jeevanonlineterminsurance.service;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.jeevanonlineterminsurance.entity.Admin;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
import com.cg.jeevanonlineterminsurance.repository.AdminDaoImpl;
/*
 * @author - Poorani
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDaoImpl admin;

	public List<Admin> getAllAdmins() {
		return admin.findAll();
	}

	public Admin findAdminById(@PathVariable(value = "id") Integer adminId) throws ResourceNotFoundException {

		Admin u = admin.findByAdminId(adminId);
		if (u == null) {
			new ResourceNotFoundException("Admin not found for this id :: " + adminId);
		}
		return u;
	}

	/*
	 * public List<admin> findByAdminIdAndPolicyId(int adminId,int
	 * policyId) { return (List<adminPolicy>)
	 * admin.findByAdminIdAndPolicyId(adminId, policyId); }
	 */
	public boolean deleteAdminById(Integer adminId) throws ResourceNotFoundException {
		Admin u = admin.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		admin.delete(u);
		if (null == u) {
			return true;
		}
		return false;
	}
	//---------------------------Term Insurance Application------------------------
	/******************************************************************************
	 * Function Name   :   saveAdmin
	 * Return Type     :   admin object (u)
	 * author          :   Poorani
	 * Description     :   Calls method saveAdmin(Admin u)
	 * *****************************************************************************
	 */
	public Admin saveAdmin(Admin u) {

		return admin.save(u);
	}
	//---------------------------Term Insurance Application------------------------
		/******************************************************************************
		 * Function Name   :   updateAdmin
		 * Return Type     :   admin object 
		 * author          :   Poorani
		 * Description     :   Calls method  updateAdmin
		 * *****************************************************************************
		 */
	public Admin updateAdmin(Integer adminId, Admin u) throws ResourceNotFoundException {
		Admin u1 = admin.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin  not found for this id :: " + adminId));
		u1.setAdminId(u.getAdminId());
		u1.setPolicyId(u.getPolicyId());
		u1.setAdminName(u.getAdminName());
		u1.setEmail(u.getEmail());
		u1.setMobileNo(u.getMobileNo());
		u1.setAge(u.getAge());
		u1.setDob(u.getDob());
		final Admin updatedAdmin = admin.save(u1);
		return updatedAdmin;
	}

	public List<Admin> saveAll() {

		return null;
	}
}
