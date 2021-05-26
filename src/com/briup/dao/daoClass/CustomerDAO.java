package com.briup.dao.daoClass;

import com.briup.bean.Customer;
import com.briup.dao.daoInterface.ICustomerDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO implements ICustomerDAO {
    @Override
    public int saveCustomer(com.briup.bean.Customer customer) {
        int i=0;
        try {
            Connection conn= JDBCUtils.getConnection();
            Customer customer1=findCustomerByName(customer.getName());
            String sql = "insert into t_customer(name,password,zipCode,address,telephone,email) values(?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getPassword());
            ps.setString(3,customer.getZipCode());
            ps.setString(4,customer.getAddress());
            ps.setString(5,customer.getTelephone());
            ps.setString(6,customer.getEmail());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public com.briup.bean.Customer findCustomerByName(String name) {
        Customer customer = new Customer();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql= "select * from t_customer where name=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()){
//                System.out.println("用户名："+rs.getString("name"));
                customer.setName(rs.getString("name"));
            }
            else {
                customer.setName("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return customer;

    }

    @Override
    public Customer login(String name, String password) {
        Customer customer = new Customer();
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql= "select * from t_customer where name=? and password=?";
            ps=conn.prepareStatement(sql);
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
        }finally {
            JDBCUtils.close(conn,ps);
        }
        return customer;
    }
}
