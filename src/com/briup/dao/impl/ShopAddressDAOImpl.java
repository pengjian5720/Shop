package com.briup.dao.impl;

import com.briup.bean.Customer;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.dao.IShopAddressDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopAddressDAOImpl implements IShopAddressDAO {
    @Override
    public List<ShopAddress> findAddressByCustomerId(Integer id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<ShopAddress> addressList = new ArrayList<ShopAddress>();
        String sql = "select * from t_shopaddress where customer_id=?";
        try {
            conn= JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //出现空指针异常
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ShopAddress shopAddress=new ShopAddress();
                shopAddress.setId(rs.getInt("id"));
                shopAddress.setReceiveName(rs.getString("receiveName"));
                shopAddress.setAddress(rs.getString("address"));
                shopAddress.setPhone(rs.getString("phone"));
                CustomerDAOImpl customerDAO=new CustomerDAOImpl();
                Customer customer = customerDAO.findCustomerById(id);
                shopAddress.setCustomer(customer);
                addressList.add(shopAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return addressList;
    }

    @Override
    public void saveAddress(ShopAddress sd) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql = "insert into t_shopaddress(receiveName,address,phone,customer_id) values (?,?,?,?)";
        try {
            conn=JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sd.getId());
            ps.setString(2,sd.getAddress());
            ps.setString(3,sd.getPhone());
            ps.setInt(4,sd.getCustomer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
    }

    @Override
    public ShopAddress findShopAddressById(Integer id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ShopAddress shopAddress = new ShopAddress();
        String sql = "select * from t_shopaddress where id=?";
        try {
            conn= JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                shopAddress.setId(rs.getInt("id"));
                shopAddress.setReceiveName(rs.getString("receiveName"));
                shopAddress.setAddress(rs.getString("address"));
                shopAddress.setPhone(rs.getString("phone"));
                CustomerDAOImpl customerDAO=new CustomerDAOImpl();
                Customer customer = customerDAO.findCustomerById(id);
                shopAddress.setCustomer(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return shopAddress;
    }
}
