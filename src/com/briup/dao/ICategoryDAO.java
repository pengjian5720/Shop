package com.briup.dao;

import java.util.List;

import com.briup.bean.Category;

public interface ICategoryDAO {
	List<Category> findAllCategories();
	//根据分类名查询分类信息
	Category findCategoryByName(String name);
	//根据分类ID查询分类信息
	Category findCategoryById(Integer id);
}
