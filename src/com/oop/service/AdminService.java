package com.oop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.oop.model.Admin;

public interface AdminService {

	public boolean addNewAdmin(Admin adm) throws SQLException, ClassNotFoundException;

	public ArrayList<Admin> getAllAdmins() throws SQLException, Exception;

	public boolean deleteAdmin(String aId) throws SQLException;

	public boolean editAdmin(Admin adm, String aId) throws SQLException;

}
