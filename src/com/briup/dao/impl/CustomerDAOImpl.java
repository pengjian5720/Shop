package com.briup.dao.impl;

import com.briup.bean.Customer;
import com.briup.dao.ICustomerDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements ICustomerDAO {
    Connection conn=null;
    PreparedStatement ps=null;

    /**
     * 向数据库插入用户信息
     * @param customer
     * @throws SQLException 产生异常时抛出给service层
     */
    @Override
    public void saveCustomer(com.briup.bean.Customer customer) throws SQLException {
        conn= JDBCUtils.getConnection();
        String sql = "insert into t_customer(name,password,zipCode,address,telephone,email) values(?,?,?,?,?,?)";
        ps=conn.prepareStatement(sql);
        ps.setString(1,customer.getName());
        ps.setString(2,customer.getPassword());
        ps.setString(3,customer.getZipCode());
        ps.setString(4,customer.getAddress());
        ps.setString(5,customer.getTelephone());
        ps.setString(6,customer.getEmail());
        ps.executeUpdate();
    }
    @Override
    public Customer findCustomerByName(String name) {
        Customer customer = new Customer();
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql= "select * from t_customer where name=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            //执行查询语句，返回查找的用户
            rs = ps.executeQuery();
            //ResultSet数据封装到customer中
            if (rs.next()){
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setZipCode(rs.getString("zipCode"));
                customer.setAddress(rs.getString("address"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return customer;

    }

//    @Override
//    public Customer login(String name, String password) {
//        Customer customer = null;
//        try {
//            conn=JDBCUtils.getConnection();
//            String sql= "select * from t_customer where name=? and password=?";
//            ps=conn.prepareStatement(sql);
//            ps.setString(1, name);
//            ps.setString(2, password);
//            ResultSet rs=ps.executeQuery();
//            if (rs.next()){
//                customer.setName(rs.getString("name"));
//                customer.setPassword(rs.getString("password"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtils.close(conn,ps);
//        }
//        return customer;
//    }
}
