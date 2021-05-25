package com.briup.dao.daoInterface;

import com.briup.bean.Customer;

public interface ICustomerDAO {
	void saveCustomer(Customer customer);
	Customer findCustomerByName(String name);
}
