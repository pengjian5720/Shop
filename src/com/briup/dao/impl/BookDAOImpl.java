package com.briup.dao.impl;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.dao.IBookDAO;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements IBookDAO {

    /**
     * 查询所有图书
     * @return
     */
    @Override
    public List<Book> findAllBooks() {
        List<Book> bookList=new ArrayList<Book>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from t_book";
        try {
            conn = JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book=new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPubDate(rs.getDate("pubDate"));
                book.setDescription(rs.getString("description"));
                CategoryDAOImpl categoryDAO=new CategoryDAOImpl();
                book.setCategory(categoryDAO.findCategoryById(rs.getInt("category_id")));
                book.setImage(rs.getString("image"));
                book.setImage(rs.getString("image"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, conn, ps);
            return bookList;
        }
    }

    /**
     * 根据图书Id查询图书信息
     * @param id
     * @return
     */
    @Override
    public Book findBookById(Integer id)  {
        Book book=new Book();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from t_book where id=?";
        try {
            conn = JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            //根据图书ID查询图书信息
            rs = ps.executeQuery();
            if (rs.next()) {
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPubDate(rs.getDate("pubDate"));
                book.setDescription(rs.getString("description"));
                CategoryDAOImpl categoryDAO=new CategoryDAOImpl();
                book.setCategory(categoryDAO.findCategoryById(rs.getInt("category_id")));
                book.setImage(rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
        }
        return book;
    }

    /**
     * 根据分类Id查找同一类型的图书
     * @param category_id
     * @return
     */
    @Override
    public List<Book> findBooksByCategoryId(Integer category_id) {
        List<Book> bookList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from t_book where category_id=?";
        try {
            conn = JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, category_id);
            //根据图书ID查询图书信息
            rs = ps.executeQuery();
            while (rs.next()) {
                Book book=new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPubDate(rs.getDate("pubDate"));
                book.setDescription(rs.getString("description"));
                book.setImage(rs.getString("image"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,conn,ps);
            return bookList;
        }
    }

}
