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
            String sql = "select * from t_category";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setCategories(findChildCategorys(rs.getInt("parent_id")));
                categorylist.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return categorylist;
    }

    @Override
    public List<Category> findChildCategorys(int parentId) {
        List<Category> categorylist = new ArrayList<Category>();
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select * from t_categoryparent_id=?";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setCategories(findChildCategorys(rs.getInt("parent_id")));
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
