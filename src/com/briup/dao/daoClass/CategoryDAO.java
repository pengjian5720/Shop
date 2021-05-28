package com.briup.dao.daoClass;

import com.briup.bean.Category;
import com.briup.dao.daoInterface.ICategoryDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    @Override
    public List<Category> findAllCategorys() {
        List<Category> categorylist = new ArrayList<Category>();
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            //一级分类信息
            String sql = "select * from t_category where parent_id='0'";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                //递归查询子分类信息
                category.setCategories(findChildCategorys(rs.getInt("id")));
                categorylist.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return categorylist;
    }
    //封装查询子列表的方法，递归调用
    public List<Category> findChildCategorys(int parentId) {
        List<Category> categorylist = new ArrayList<Category>();
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select * from t_category where parent_id=?";
            //查询子列表
            ps = conn.prepareStatement(sql);
            ps.setInt(1,parentId);
            //接收数据集
            rs=ps.executeQuery();
            //将查询到的子列表封装到list中
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setCategories(findChildCategorys(rs.getInt("id")));
                categorylist.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return categorylist;
    }
}
