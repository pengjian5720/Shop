package com.briup.dao.impl;

import com.briup.bean.OrderForm;
import com.briup.bean.ShopAddress;
import com.briup.dao.IOrderFormDAO;
import com.briup.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderFormDAOImpl implements IOrderFormDAO {
    @Override
    public void saveOrderForm(OrderForm of) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql = "insert into t_shopaddress(receiveName,address,phone,customer_id) values (?,?,?,?)";

        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,of.getShopAddress().getReceiveName());
            ps.setString(2,of.getShopAddress().getAddress());
            ps.setString(3,of.getShopAddress().getPhone());
            ps.setInt(4,of.getCustomer().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
    }

    @Override
    public OrderForm findOrderFormByOrderid(Integer orderid) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        OrderForm orderForm = new OrderForm();
        String sql = "select * from t_orderform where id=?";
        try {
            conn=JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderid);
            rs= ps.executeQuery();
            while (rs.next()) {
                ShopAddressDAOImpl shopAddressDAO=new ShopAddressDAOImpl();
                ShopAddress shopAddress=shopAddressDAO.findShopAddressById(rs.getInt("shopAddress_id"));
                orderForm.setShopAddress(shopAddress);
                OrderLineDAOImpl orderLineDAO=new OrderLineDAOImpl();
                orderForm.setOrderLines(orderLineDAO.findOrderLineByOrderId(rs.getInt("orderForm_id")));
                orderForm.setOrderdate(rs.getDate("orderDate"));
                CustomerDAOImpl customerDAO=new CustomerDAOImpl();
                orderForm.setCustomer(customerDAO.findCustomerById(rs.getInt("customer_id")));
                orderForm.setCost(rs.getDouble("cost"));
                orderForm.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return orderForm;
    }

    @Override
    public List<OrderForm> findOrderFormByCustomerId(Integer id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<OrderForm> orderFormList = new ArrayList<OrderForm>();
        String sql = "select * from t_orderform where customer_id=?";
        try {
            conn=JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs= ps.executeQuery();
            while (rs.next()) {
                OrderForm orderFrom = new OrderForm();
                ShopAddressDAOImpl shopAddressDAO=new ShopAddressDAOImpl();
                ShopAddress shopAddress=shopAddressDAO.findShopAddressById(rs.getInt("shopAddress_id"));
                orderFrom.setShopAddress(shopAddress);
                OrderLineDAOImpl orderLineDAO=new OrderLineDAOImpl();
                orderFrom.setOrderLines(orderLineDAO.findOrderLineByOrderId(rs.getInt("orderForm_id")));
                orderFrom.setOrderdate(rs.getDate("orderDate"));
                CustomerDAOImpl customerDAO=new CustomerDAOImpl();
                orderFrom.setCustomer(customerDAO.findCustomerById(rs.getInt("customer_id")));
                orderFrom.setCost(rs.getDouble("cost"));
                orderFrom.setId(rs.getInt("id"));
                orderFormList.add(orderFrom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return orderFormList;
    }

    @Override
    public void deleteOrderFormById(Integer id) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql = "delete from t_orderform where id=?";
        try {
            conn=JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
    }
}
