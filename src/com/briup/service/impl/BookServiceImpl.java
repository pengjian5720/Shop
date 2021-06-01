package com.briup.service.impl;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.dao.impl.BookDAOImpl;
import com.briup.dao.impl.CategoryDAOImpl;
import com.briup.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
    @Override
    public List<Book> findAllBooks() {
        BookDAOImpl bookDAO=new BookDAOImpl();
        return bookDAO.findAllBooks();
    }

    @Override
    public Book findBookById(Integer id) {
        return null;
    }

    @Override
    public List<Book> findBooksByCategoryName(String name) {
        BookDAOImpl bookDAO=new BookDAOImpl();
        CategoryDAOImpl categoryDAO=new CategoryDAOImpl();
//        System.out.println("分类名："+name);
        Category category = categoryDAO.findCategoryByName(name);
//        System.out.println("分类id:"+category.getId());
        List<Book> bookList=bookDAO.findBooksByCategoryId(category.getId());
        for (Book book:bookList) {
            book.setCategory(category);
            System.out.println("图片路径："+book.getImage());
        }
        return bookList;
    }
}
