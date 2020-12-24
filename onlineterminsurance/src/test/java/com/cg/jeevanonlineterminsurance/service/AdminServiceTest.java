package com.cg.jeevanonlineterminsurance.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeevanonlineterminsurance.entity.Admin;
import com.cg.jeevanonlineterminsurance.repository.AdminDaoImpl;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mockito;
/*
 * Test of Service layer
 * @author - Dharani
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {
	@MockBean
	private AdminDaoImpl adminDaoImpl;

	@Autowired
	private AdminService adminService;
	//test for get admin details
	@Test
	public void testGetAdminById() throws Exception {
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");

		Mockito.when(adminDaoImpl.findByAdminId(10178278)).thenReturn(admin);
		// findAdminById()).get()).thenReturn(admin);
		// Mockito.when(adminDaoImpl.findById(admin.getAdminId()).get()).thenReturn(admin);
		assertThat(adminService.findAdminById(10178278)).isEqualTo(admin);
	}
	//test for delect admin details
	@Test
	void testDeleteAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setAdminId(10178274);
		admin.setPolicyId(401273827);
		admin.setAdminName("Sanya");
		admin.setEmail("sanya123@gmail.com");
		admin.setMobileNo("7893436347");
		admin.setAge(25);
		admin.setDob("13-08-1996");
		adminDaoImpl.deleteById(admin.getAdminId());
		System.out.println(adminDaoImpl.findById(10178274));
		assertThat(adminDaoImpl.findById(10178274).isEmpty());
	}
	//test for update admin details
	@Test
	void testUpdateAdminById() throws Exception {
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");

		Mockito.when(adminDaoImpl.findByAdminId(10178278)).thenReturn(admin);
		admin.setMobileNo("6543874051");
		Mockito.when(adminDaoImpl.save(admin)).thenReturn(admin);
		System.out.println(admin.getMobileNo());
		// assertThat(adminPolicyService.updateAdmin(10178263,
		// admin)).isEqualTo(admin);
	}
	//test for get admin details
	@Test
	void testGetAllAdminPolicies() {
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");

		Admin admin1 = new Admin();
		admin.setAdminId(10178254);
		admin.setPolicyId(40127672);
		admin.setAdminName("Manyatha");
		admin.setEmail("manyatha453@gmail.com");
		admin.setMobileNo("7487589312");
		admin.setAge(24);
		admin.setDob("12-09-1997");
		Admin admin2 = new Admin();
		admin2.setAdminId(10178263);
		admin2.setPolicyId(40127382);
		admin2.setAdminName("Hema");
		admin2.setEmail("hema26@gmail.com");
		admin2.setMobileNo("7845326170");
		admin2.setAge(27);
		admin2.setDob("16-07-1993");
		Admin admin3 = new Admin();
		admin3.setAdminId(10178263);
		admin3.setPolicyId(40127382);
		admin3.setAdminName("Hema");
		admin3.setEmail("hema26@gmail.com");
		admin3.setMobileNo("7845326170");
		admin3.setAge(27);
		admin3.setDob("16-07-1993");
		List<Admin> adminList = new ArrayList<>();
		adminList.add(admin);
		adminList.add(admin1);
		adminList.add(admin2);
		adminList.add(admin3);
		Mockito.when(adminDaoImpl.findAll()).thenReturn(adminList);
		assertThat(adminService.getAllAdmins()).isEqualTo(adminList);
	}
	//test for save admin details
	@Test
	void testSaveAdmin() {
		Admin admin = new Admin();
		admin.setAdminId(10878781);
		admin.setPolicyId(40255512);
		admin.setAdminName("Sharad Malhotra");
		admin.setEmail("malhotrasharad21@gmail.com");
		admin.setMobileNo("8989891212");
		admin.setAge(25);
		admin.setDob("21-12-1995");

	}
}
