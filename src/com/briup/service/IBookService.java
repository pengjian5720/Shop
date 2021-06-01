package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

import javax.servlet.ServletContext;

public interface IBookService {
	//查询所有书籍信息
	List<Book> findAllBooks();
	//通过书籍ID查询书籍信息
	Book findBookById(Integer id);
	//通过分类ID查询对应的所有书籍列表
	List<Book> findBooksByCategoryName(String name);
}
