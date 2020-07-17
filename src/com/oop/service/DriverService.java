package com.oop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.oop.model.Driver;

public interface DriverService {

	public boolean addNewDriver(Driver dri) throws SQLException, ClassNotFoundException;

	public ArrayList<Driver> getAllDrivers() throws SQLException, Exception;

	public boolean deleteDriver(String dId) throws SQLException;

	public boolean editDriver(Driver dri, String dId) throws SQLException;
	
}
