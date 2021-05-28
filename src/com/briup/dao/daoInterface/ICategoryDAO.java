package com.briup.dao.daoInterface;

import java.util.List;

import com.briup.bean.Category;

public interface ICategoryDAO {
	List<Category> findAllCategorys();
}
