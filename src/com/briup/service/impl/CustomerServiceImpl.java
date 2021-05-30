package com.briup.service.impl;

import com.briup.bean.Customer;
import com.briup.dao.impl.CustomerDAOImpl;
import com.briup.service.ICustomerService;

import java.sql.SQLException;

public class CustomerServiceImpl implements ICustomerService {
    CustomerDAOImpl customerDAOImpl =new CustomerDAOImpl();
    @Override
    public boolean register(Customer customer) {
        int i=0;
        //如果用户名未被注册，注册成功
        if((customerDAOImpl.findCustomerByName(customer.getName()).getName()==null)){
            try {
                customerDAOImpl.saveCustomer(customer);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerDAOImpl.findCustomerByName(name);
    }

    @Override
    public Customer login(String name, String password) {
        //调用DAO方法，从数据库中查找用户信息
        Customer customer = customerDAOImpl.findCustomerByName(name);
        //校验用户名和密码
        if (customer != null) {
            //如果用户输入密码正确，则返回数据库中查询的customer，反之，则返回Null
            if (password.equals(customer.getPassword())) {
                return customer;
            } else {
                return null;
            }
        } else {
            //如果用户不存在，返回null
            return null;
        }
    }
}
