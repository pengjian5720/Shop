package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;

public interface IBookDAO {
	List<Book> findAllBooks();
	Book findBookById(Integer id);
}
