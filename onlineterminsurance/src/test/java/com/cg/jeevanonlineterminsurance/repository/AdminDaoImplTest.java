package com.cg.jeevanonlineterminsurance.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeevanonlineterminsurance.entity.Admin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
/*
 * Test of entity layer
 * @author - Dharani
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminDaoImplTest {
	@Autowired
	private AdminDaoImpl adminDaoImpl;
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewAdmin() throws Exception {
		Admin user = getAdmin();
		Admin saveInDb = testEntityManager.persist(user);
		Admin getInDb = adminDaoImpl.findById(user.getAdminPolicyId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}
	// test for admin dtais
	private Admin getAdmin() {
		Admin user = new Admin();
		user.setAdminId(10178278);
		user.setPolicyId(401273827);
		user.setAdminName("Sanya");
		user.setEmail("sanya123@gmail.com");
		user.setMobileNo("7893436347");
		user.setAge(25);
		user.setDob("13-08-1996");
		return user;
	}
	//test for get admin details
	@Test
	public void testGetAdminById() throws Exception {
		Admin user = new Admin();
		user.setAdminId(10178267);
		user.setPolicyId(401273851);
		user.setAdminName("Suraj");
		user.setEmail("suraj7883@gmail.com");
		user.setMobileNo("7879101818");
		user.setAge(28);
		user.setDob("07-02-1993");
		Admin saveInDb = testEntityManager.persist(user);
		Admin getInDb = adminDaoImpl.findById(user.getAdminPolicyId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllAdmins() throws Exception {
		Admin user1 = new Admin();
		user1.setAdminId(10178263);
		user1.setPolicyId(401273823);
		user1.setAdminName("Hema");
		user1.setEmail("hema26@gmail.com");
		user1.setMobileNo("7845326170");
		user1.setAge(27);
		user1.setDob("16-07-1993");
		Admin user2 = new Admin();
		user2.setAdminId(10132263);
		user2.setPolicyId(411273823);
		user2.setAdminName("Rajesh");
		user2.setEmail("rajesh1456@gmail.com");
		user2.setMobileNo("888324151");
		user2.setAge(35);
		user2.setDob("09-03-1986");
		Admin user3 = new Admin();
		user3.setAdminId(10178263);
		user3.setPolicyId(40127382);
		user3.setAdminName("Hema");
		user3.setEmail("hema26@gmail.com");
		user3.setMobileNo("7845326170");
		user3.setAge(27);
		user3.setDob("16-07-1993");
		Admin user4 = new Admin();
		user4.setAdminId(10178263);
		user4.setPolicyId(40127382);
		user4.setAdminName("Hema");
		user4.setEmail("hema26@gmail.com");
		user4.setMobileNo("7845326170");
		user4.setAge(27);
		user4.setDob("16-07-1993");
		testEntityManager.persist(user1);
		testEntityManager.persist(user2);
		testEntityManager.persist(user3);
		testEntityManager.persist(user4);
		List<Admin> userList = (List<Admin>) adminDaoImpl.findAll();
		assertEquals(4, userList.size());

	}
	//test for delete admin detais
	@Test
	public void testDeleteAdminById() throws Exception {
		Admin user1 = new Admin();
		user1.setAdminId(10178263);
		user1.setPolicyId(401273823);
		user1.setAdminName("Hema");
		user1.setEmail("hema26@gmail.com");
		user1.setMobileNo("7845326170");
		user1.setAge(27);
		user1.setDob("16-07-1993");
		Admin user2 = new Admin();
		user2.setAdminId(10789898);
		user2.setPolicyId(40211123);
		user2.setAdminName("Varsha Singhania");
		user2.setEmail("varsha.singhania@gmail.com");
		user2.setMobileNo("8000067677");
		user2.setAge(22);
		user2.setDob("01-01-1998");
		Admin user3 = testEntityManager.persist(user1);
		testEntityManager.persist(user2);
		testEntityManager.remove(user3);
		List<Admin> users = (List<Admin>) adminDaoImpl.findAll();
		assertEquals(users.size(), 1);

	}
	//test for update admin details
	@Test
	public void testUpdateAdmin() {
		Admin user = new Admin();
		user.setAdminId(10878781);
		user.setPolicyId(40255512);
		user.setAdminName("Sharad Malhotra");
		user.setEmail("malhotrasharad21@gmail.com");
		user.setMobileNo("8989891212");
		user.setAge(25);
		user.setDob("21-12-1995");
		testEntityManager.persist(user);
		Admin getFromDb = adminDaoImpl.findById(user.getAdminPolicyId()).get();
		getFromDb.setMobileNo("7878212121");
		testEntityManager.persist(getFromDb);
		assertThat(getFromDb.getMobileNo()).isEqualTo("7878212121");
	}
}
