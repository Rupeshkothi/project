package com.capgemini.surveyManagementSystem.dao;

import com.capgemini.surveyManagementSystem.beans.Admin;
import com.capgemini.surveyManagementSystem.factory.Factory;

public class AdminDAOImpl implements AdminDAO {
	Admin admin = null;

	public AdminDAOImpl() {
		admin = Factory.getAdminInstance();
		admin.setUsername("admin");
		admin.setPassword("admin");
	}

	public boolean validateAdmin(String username, String password) {
		if (username.contentEquals(admin.getUsername()) && password.equals(admin.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
}
