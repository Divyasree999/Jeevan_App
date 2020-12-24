package com.cg.jeevanonlineterminsurance.control;
import com.cg.jeevanonlineterminsurance.entity.Admin;
import com.cg.jeevanonlineterminsurance.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
/*
 * Test of Controller layer
 * @author - Dharani
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AdminService adminService;
	// testing of add admin
	@Test
	public void testCreateAdmin() throws Exception {
		String URI = "/api/v2/saveadmin";
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");

		String jsonInput = this.converttoJson(admin);

		Mockito.when(adminService.saveAdmin(Mockito.any(Admin.class))).thenReturn(admin);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	// testing of get admin
	@Test
	public void testGetAdminById() throws Exception {
		String URI = "/api/v2/findadmin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(10178267);
		admin.setPolicyId(401273851);
		admin.setAdminName("Suraj");
		admin.setEmail("suraj7883@gmail.com");
		admin.setMobileNo("7879101818");
		admin.setAge(28);
		admin.setDob("07-02-1993");

		String jsonInput = this.converttoJson(admin);

		Mockito.when(adminService.findAdminById(Mockito.any())).thenReturn(admin);
		// Assert.assertTrue(adminService.findAdminById());
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 10178267).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	//Testing to update admin
	@Test
	public void testUpdateAdmin() throws Exception {
		String URI = "/api/v2/updateadmin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");
		String jsonInput = this.converttoJson(admin);

		Mockito.when(adminService.updateAdmin(Mockito.any(), Mockito.any())).thenReturn(admin);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 10178263)
				.accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	// testing of delete admin
	@Test
	public void testDeleteAdmin() throws Exception {
		String URI = "/api/v2/deleteadmin/{id}";
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");

		Mockito.when(adminService.findAdminById(Mockito.any())).thenReturn(admin);
		Mockito.when(adminService.deleteAdminById(Mockito.any())).thenReturn(true);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.delete(URI, 10178263).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

		Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	// testing to get admin details
	@Test
	public void testGetAllAdmins() throws Exception {
		String URI = "/api/v2/getAllAdmins";
		Admin admin = new Admin();
		admin.setAdminId(10178263);
		admin.setPolicyId(40127382);
		admin.setAdminName("Hema");
		admin.setEmail("hema26@gmail.com");
		admin.setMobileNo("7845326170");
		admin.setAge(27);
		admin.setDob("16-07-1993");
        Admin admin1 = new Admin();
		admin1.setAdminId(10178263);
		admin1.setPolicyId(40127382);
		admin1.setAdminName("Hema");
		admin1.setEmail("hema26@gmail.com");
		admin1.setMobileNo("7845326170");
		admin1.setAge(27);
		admin1.setDob("16-07-1993");
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

		String jsonInput = this.converttoJson(adminList);

		Mockito.when(adminService.getAllAdmins()).thenReturn(adminList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}
}
