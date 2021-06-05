package com.briup.dao;

import com.briup.bean.Customer;

import java.sql.SQLException;

public interface ICustomerDAO {
	void saveCustomer(Customer customer) throws SQLException;
	Customer findCustomerByName(String name);

	Customer findCustomerById(Integer id);
}
