package com.briup.service.serviceClass;

import com.briup.bean.Customer;
import com.briup.service.serviceInterface.ICustomerService;

public class LoginService implements ICustomerService {
    @Override
    public void register(Customer customer) {

    }

    @Override
    public Customer findCustomerByName(String name) {

        return null;
    }

    @Override
    public Customer login(String name, String password) {
        return null;
    }
}
