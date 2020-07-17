package com.oop.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.model.Vehicle;
import com.oop.service.VehicleService;
import com.oop.util.DBConnection;

public class VehicleServiceimpl implements VehicleService{


	private static Connection conn;
	
	public VehicleServiceimpl(){
		conn = DBConnection.getConnection();
	}
	public boolean addNewVehicle(Vehicle vhl) throws SQLException{
		String sql = "Insert into vehicle values(?,?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1, vhl.getvId());
		stm.setObject(2, vhl.getModel());
		stm.setObject(3, vhl.getRegistrationNo());
		stm.setObject(4, vhl.getType());
		stm.setObject(5, vhl.getSeat());
		
		int res = stm.executeUpdate();
		return res>0;
	}
	
	@Override
	public ArrayList<Vehicle> getAllVehicles() throws Exception {
		String sql = "Select * from vehicle";
		Statement stm  = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<Vehicle> vhlList = new ArrayList<Vehicle>();
		
		while(rst.next()){
			Vehicle vhl = new Vehicle();
			
			vhl.setvId(rst.getString("vId"));
			vhl.setModel(rst.getString("model"));
			vhl.setRegistrationNo(rst.getString("registrationNo"));
			vhl.setType(rst.getString("type"));
			vhl.setSeat(rst.getString("seat"));
			
			vhlList.add(vhl);
		}
		return vhlList;
	}
	@Override
	public boolean deleteVehicle(String vId) throws SQLException {
		
		String sql = "Delete from vehicle where vId='"+vId+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	public boolean editVehicle(Vehicle vhl, String vId) throws SQLException{
			String sql = "Update vehicle set model= ?, registrationNo= ?, type= ?, seat= ? where vId='"+vId+"'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, vhl.getModel());
			ps.setString(2, vhl.getRegistrationNo());
			ps.setString(3, vhl.getType());
			ps.setString(4, vhl.getSeat());

			int res = ps.executeUpdate();
			return res>0;	
	}		
}