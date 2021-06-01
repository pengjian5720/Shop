package com.briup.dao.impl;

import com.briup.bean.Category;
import com.briup.dao.ICategoryDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDAO {
    /**
     *查询所有商品各级分类信息
     * @return 分类信息列表
     */
    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<Category>();
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
                //递归查询各级子分类信息
                category.setCategories(findChildCategorys(rs.getInt("id")));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return categories;
    }

    /**
     * 根据分类名查询分类信息
     * @param name
     * @return
     */
    @Override
    public Category findCategoryByName(String name) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from t_category where name=?";
        Connection conn=null;
        Category category=new Category();
        try {
            conn = JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs= ps.executeQuery();
            if (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return category;
    }
    /**
     *根据分类Id查询分类信息
     *
     */
    @Override
    public Category findCategoryById(Integer id) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from t_category where id=?";
        Connection conn=null;
        Category category=new Category();
        try {
            conn = JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return category;
    }

    /**
     * 递归查询二级分类、三级分类及之后所有等级分类的子分类
     * @param parentId 父级分类id
     * @return 以列表形式返回父级分类所包含的所有子分类
     */
    public List<Category> findChildCategorys(int parentId) {
        List<Category> categorylist = new ArrayList<Category>();
        PreparedStatement ps=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql = "select * from t_category where parent_id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,parentId);
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
