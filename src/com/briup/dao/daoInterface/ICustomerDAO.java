package com.briup.dao.daoInterface;

import com.briup.bean.Customer;

public interface ICustomerDAO {
	int saveCustomer(Customer customer);
	Customer findCustomerByName(String name);
	Customer login(String name,String password);
}
