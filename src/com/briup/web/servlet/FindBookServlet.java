package com.briup.web.servlet;

import com.briup.bean.Book;
import com.briup.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindBookServlet")
public class FindBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取从客户端传来的图书Id
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        //调用service层方法，根据ID查找图书信息
        BookServiceImpl bookService=new BookServiceImpl();
        Book book = bookService.findBookById(bookId);
        //将图书信息返回给客户端
        request.setAttribute("book", book);
        request.getRequestDispatcher("viewBook.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
