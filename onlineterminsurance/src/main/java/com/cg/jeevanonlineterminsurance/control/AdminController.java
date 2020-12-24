package com.cg.jeevanonlineterminsurance.control;
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

import com.cg.jeevanonlineterminsurance.entity.Admin;
import com.cg.jeevanonlineterminsurance.exception.ResourceNotFoundException;
import com.cg.jeevanonlineterminsurance.service.AdminService;
/**Implements controller layer
* 
* @author poorani
*
*/
@RestController
@RequestMapping("/api/v2")
public class AdminController {
	@Autowired
	private AdminService adminService;
	/*
	 * get admin details
	 */
	@GetMapping("/getAllAdmins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	/*
	 * find admin details based on admin id
	 */
	@GetMapping("/findadmin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Integer adminId) throws ResourceNotFoundException {
		Admin admin= adminService.findAdminById(adminId);
		return  ResponseEntity.ok(admin);
	}
	/*
	 * create admin details based on admin id
	 */
	@PostMapping("/saveadmin")
	public Admin createAdmin( @RequestBody Admin admin ) {
		return adminService.saveAdmin(admin);
	}
	/*
	 * update admin details based on admin id
	 */
	@PutMapping("/updateadmin/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable(value = "id") Integer adminId,
			 @RequestBody Admin admin) throws ResourceNotFoundException {
		Admin admin1= adminService.updateAdmin(adminId, admin);
		return  ResponseEntity.ok(admin1);
	}
	/*
	 * Delete admin details based on admin id
	 */
	 @DeleteMapping("/deleteadmin/{id}")
	 public ResponseEntity<Boolean> deleteAdmin(@PathVariable(value = "id") Integer adminId,@RequestBody Admin admin) throws ResourceNotFoundException	{
			Boolean admin1 = adminService.deleteAdminById(adminId);
			return  ResponseEntity.ok(admin1);
    }
}