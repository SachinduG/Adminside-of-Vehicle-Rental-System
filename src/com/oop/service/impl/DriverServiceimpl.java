package com.oop.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.model.Driver;
import com.oop.service.DriverService;
import com.oop.util.DBConnection;

public class DriverServiceimpl implements DriverService{
	
	private static Connection conn;
	
	public DriverServiceimpl(){
		conn = DBConnection.getConnection();
	}
	public boolean addNewDriver(Driver dri) throws SQLException{
		String sql = "Insert into driver values(?,?,?,?)";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setObject(1, dri.getdId());
		stm.setObject(2, dri.getdName());
		stm.setObject(3, dri.getdPhone());
		stm.setObject(4, dri.getdAddress());
		
		int res = stm.executeUpdate();
		return res>0;
	}
	
	@Override
	public ArrayList<Driver> getAllDrivers() throws Exception {
		String sql = "Select * from driver";
		Statement stm  = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<Driver> driList = new ArrayList<Driver>();
		
		while(rst.next()){
			Driver dri = new Driver();
			
			dri.setdId(rst.getString("dId"));
			dri.setdName(rst.getString("dName"));
			dri.setdPhone(rst.getString("dPhone"));
			dri.setdAddress(rst.getString("dAddress"));
			
			driList.add(dri);
		}
		return driList;
	}
	@Override
	public boolean deleteDriver(String dId) throws SQLException {
		
		String sql = "Delete from driver where dId='"+dId+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	public boolean editDriver(Driver dri, String dId) throws SQLException{
		String sql ="Update driver set dName= ?, dPhone= ?, dAddress= ? where dId='"+dId+"'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
			
		ps.setString(1, dri.getdName());
		ps.setString(2, dri.getdPhone());
		ps.setString(3, dri.getdAddress());	
		
		int res = ps.executeUpdate();
		return res>0;
	}		
}
