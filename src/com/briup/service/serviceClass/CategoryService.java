package com.briup.service.serviceClass;

import com.briup.bean.Category;
import com.briup.dao.daoClass.CategoryDAO;
import com.briup.service.serviceInterface.ICategoryService;
import com.briup.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Override
    public List<Category> findAllCategorys() {
        CategoryDAO categoryDAO=new CategoryDAO();
        List<Category> list=categoryDAO.findAllCategorys();
        return list;
    }
}
