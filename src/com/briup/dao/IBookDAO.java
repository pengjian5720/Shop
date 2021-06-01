package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;

public interface IBookDAO {
	List<Book> findAllBooks();
	Book findBookById(Integer id);
	//根据分类id查询商品
	List<Book> findBooksByCategoryId(Integer category_id);
}
