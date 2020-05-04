package com.capgemini.surveyManagementSystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.capgemini.surveyManagementSystem.beans.Admin;
import com.capgemini.surveyManagementSystem.factory.Factory;

class AdminDAOImplTest {
	@Test
	@Tag("Validate Login")
	void testAdminLogin() {
		Admin admin = Factory.getAdminInstance();
		AdminDAO adminDAO = Factory.getAdminDAOInstance();
		admin.setUsername("admin");
		admin.setPassword("admin");
		assertEquals(true, adminDAO.validateAdmin("admin", "admin"));
	}

	@Test
	@Tag("Validate Login")
	void testAdminLogin1() {
		Admin admin = Factory.getAdminInstance();
		AdminDAO adminDAO = Factory.getAdminDAOInstance();
		admin.setUsername("admin");
		admin.setPassword("admin");
		assertEquals(false, adminDAO.validateAdmin("admin", "admin"));
	}
}
