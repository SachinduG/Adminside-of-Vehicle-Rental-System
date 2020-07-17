package com.oop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.oop.model.Vehicle;

public interface VehicleService {
	
	public boolean addNewVehicle(Vehicle vhl) throws SQLException, ClassNotFoundException;

	public ArrayList<Vehicle> getAllVehicles() throws SQLException, Exception;

	public boolean deleteVehicle(String vId) throws SQLException;

	public boolean editVehicle(Vehicle vhl, String vId) throws SQLException;	
}
