package com.briup.dao;

import java.util.List;

import com.briup.bean.Category;

public interface ICategoryDAO {
	List<Category> findAllCategories();
}
