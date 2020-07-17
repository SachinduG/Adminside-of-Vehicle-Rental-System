package com.oop.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.oop.model.Admin;
import com.oop.service.AdminService;
import com.oop.util.DBConnection;

public class AdminServiceimpl implements AdminService{
	
	private static Connection conn;
	
	public AdminServiceimpl(){
		conn = DBConnection.getConnection();
	}
	public boolean addNewAdmin(Admin adm) throws SQLException{
		
		String sql = "Insert into admin values(?,?,?,?,?)";
		
		PreparedStatement stm = conn.prepareStatement(sql);
		
		stm.setObject(1, adm.getaId());
		stm.setObject(2, adm.getaName());
		stm.setObject(3, adm.getaEmail());
		stm.setObject(4, adm.getaPhone());
		stm.setObject(5, adm.getaPassword());
		
		int res = stm.executeUpdate();
		return res>0;
	}
	
	@Override
	public ArrayList<Admin> getAllAdmins() throws Exception {
		
		String sql = "Select * from admin";
		
		Statement stm  = conn.createStatement();
		
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<Admin> admList = new ArrayList<Admin>();
		
		while(rst.next()){
			Admin adm = new Admin();
			
			adm.setaId(rst.getString("aId"));
			adm.setaName(rst.getString("aName"));
			adm.setaEmail(rst.getString("aEmail"));
			adm.setaPhone(rst.getString("aPhone"));
			adm.setaPassword(rst.getString("aPassword"));
			
			admList.add(adm);
		}
		return admList;
	}
	@Override
	public boolean deleteAdmin(String aId) throws SQLException {
		
		String sql = "Delete from admin where aId='"+aId+"'";
		
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql)>0;
	}
	@Override
	public boolean editAdmin(Admin adm, String aId) throws SQLException {
		
		String sql = "Update admin set aName= ?, aEmail=?, aPhone= ?, aPassword= ? where aId='"+aId+"'";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, adm.getaName());
		ps.setObject(2, adm.getaEmail());
		ps.setObject(3, adm.getaPhone());
		ps.setObject(4, adm.getaPassword());
		
		int res = ps.executeUpdate();
		return res>0;
	}
		
}
