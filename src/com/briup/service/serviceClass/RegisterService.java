package com.briup.service.serviceClass;

import com.briup.bean.Customer;
import com.briup.dao.daoClass.CustomerDAO;
import com.briup.service.serviceInterface.ICustomerService;

public class RegisterService  implements ICustomerService {

    @Override
    public int register(Customer customer) {
        CustomerDAO customerDAO=new CustomerDAO();
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer findCustomerByName(String name) {
        CustomerDAO customerDAO=new CustomerDAO();
        return customerDAO.findCustomerByName(name);
    }

    @Override
    public Customer login(String name, String password) {
        return null;
    }
}
