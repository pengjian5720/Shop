package com.briup.service.serviceClass;

import com.briup.bean.Customer;
import com.briup.dao.daoClass.CustomerDAO;
import com.briup.service.serviceInterface.ICustomerService;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService implements ICustomerService {
    @Override
    public int register(Customer customer) {
        return 0;
    }

    @Override
    public Customer findCustomerByName(String name) {

        return null;
    }

    @Override
    public Customer login(String name, String password) {
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.login(name, password);
    }
}
