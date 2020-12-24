package com.cg.jeevanonlineterminsurance.service;
import java.util.List;
import com.cg.jeevanonlineterminsurance.entity.Admin;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
/*
 * @author - Poorani
 */
public interface AdminService {
	public List<Admin> getAllAdmins();
	public Admin findAdminById(Integer adminId) throws ResourceNotFoundException;
	public boolean deleteAdminById(Integer adminId) throws ResourceNotFoundException;
	public Admin saveAdmin(Admin admin);
	public Admin updateAdmin(Integer adminId, Admin admin) throws ResourceNotFoundException;
	// public List<adminPolicy> findByAdminIdAndPolicyId(int adminId,int policyId);
}
