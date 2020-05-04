package com.capgemini.surveyManagementSystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Admin;
import com.capgemini.surveyManagementSystem.dao.AdminDAO;
import com.capgemini.surveyManagementSystem.factory.Factory;

class AdminServiceTest {

	@Test
	@Tag("ValidateLogin")
	void testAdminService() {
		Admin admin = Factory.getAdminInstance();
		AdminDAO adminDAO = Factory.getAdminDAOInstance();
		admin.setUsername("admin");
		admin.setPassword("admin");
		assertEquals(true, adminDAO.validateAdmin("admin", "admin"));
	}

	@Test
	@Tag("ValidateLogin")
	void testAdminService1() {
		Admin admin = Factory.getAdminInstance();
		AdminDAO adminDAO = Factory.getAdminDAOInstance();
		admin.setUsername("admin");
		admin.setPassword("admin");
		assertEquals(false, adminDAO.validateAdmin("admin", "admin"));
	}

	@Test
	@Tag("AfterLogin")
	void testAfterLogin() {
		assertEquals(true, AdminService.afterLogin());

	}
}
