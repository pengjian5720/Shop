package com.briup.dao.impl;

import com.briup.bean.OrderLine;
import com.briup.dao.IOrderLineDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderLineDAOImpl implements IOrderLineDAO {
    @Override
    public void saveOrderLine(OrderLine ol) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql = "insert into t_orderline values (?,?,?,?)";
        try {
            conn= JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1,ol.getNum());
            ps.setDouble(2,ol.getCost());
            ps.setInt(3,ol.getBook().getId());
            ps.setInt(4,ol.getOrderForm().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
    }

    @Override
    public List<OrderLine> findOrderLineByOrderId(Integer id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<OrderLine> orderLineList = new ArrayList<OrderLine>();
        String sql = "select * from t_orderline where orderForm_id=?";
        try {
            conn= JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()) {
                OrderLine orderLine=new OrderLine();
                orderLine.setId(rs.getInt("id"));
                orderLine.setNum(rs.getLong("num"));
                orderLine.setCost(rs.getDouble("cost"));
                BookDAOImpl bookDAO=new BookDAOImpl();
                orderLine.setBook(bookDAO.findBookById(rs.getInt("book_id")));
                OrderFormDAOImpl orderFromDAO =new OrderFormDAOImpl();
                orderFromDAO.findOrderFormByOrderid(rs.getInt("orderForm_id"));
                orderLine.setOrderForm(orderFromDAO.findOrderFormByOrderid(rs.getInt("orderForm_id")));
                orderLineList.add(orderLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return orderLineList;
    }

    @Override
    public void deleteOrderLineByCollection(Collection<OrderLine> orderLines) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql = "delete from t_orderline where id=?";
        try {
            conn= JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (OrderLine ol : orderLines) {
                ps.setInt(1, ol.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }
    }
}
