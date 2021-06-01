package com.briup.web.servlet;

import com.briup.bean.Book;
import com.briup.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookListServlet")
public class DisplayBookListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String categoryName0 = request.getParameter("categoryName0");
        String categoryName = request.getParameter("categoryName");
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> bookList= bookService.findBooksByCategoryName(categoryName);
        request.setAttribute("bookList",bookList);
        request.setAttribute("categoryName0",categoryName0);
        request.setAttribute("categoryName",categoryName);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
