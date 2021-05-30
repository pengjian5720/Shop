package com.briup.service.impl;

import com.briup.bean.Category;
import com.briup.dao.impl.CategoryDAOImpl;
import com.briup.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    @Override
    public List<Category> findAllCategories() {
        CategoryDAOImpl categoryDAOImpl =new CategoryDAOImpl();
        List<Category> list= categoryDAOImpl.findAllCategories();
        return list;
    }
}
