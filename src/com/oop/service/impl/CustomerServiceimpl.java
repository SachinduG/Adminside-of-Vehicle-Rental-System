package com.oop.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.oop.model.Customer;
import com.oop.service.CustomerService;
import com.oop.util.DBConnection;

public class CustomerServiceimpl implements CustomerService{
	
	private static Connection conn;
	
	public CustomerServiceimpl(){
		conn = DBConnection.getConnection();
	}

	@Override
	public ArrayList<Customer> getAllCustomers() throws Exception {
		String sql = "Select * from customer";
		Statement stm  = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		
		while(rst.next()){
			Customer cus = new Customer();
			
			cus.setcId(rst.getString("cId"));
			cus.setcName(rst.getString("cName"));
			cus.setcPhone(rst.getString("cPhone"));
			cus.setcEmail(rst.getString("cEmail"));
			cus.setcAddress(rst.getString("cAddress"));
			
			cusList.add(cus);
		}
		return cusList;
	}
}