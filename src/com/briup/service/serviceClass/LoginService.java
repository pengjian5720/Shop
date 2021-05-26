package com.briup.service.serviceClass;

import com.briup.bean.Customer;
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
        Customer customer = new Customer();
        try {
            Connection conn=JDBCUtils.getConnection();
            String sql= "select * from t_customer where name=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
            }
            else {
                customer.setName("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
