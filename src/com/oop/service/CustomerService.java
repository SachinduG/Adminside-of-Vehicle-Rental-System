package com.oop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.oop.model.Customer;

public interface CustomerService {

	public ArrayList<Customer> getAllCustomers() throws SQLException, Exception;

}
