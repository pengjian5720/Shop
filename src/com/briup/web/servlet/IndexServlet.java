package com.briup.web.servlet;

import com.briup.bean.Category;
import com.briup.service.serviceClass.CategoryService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application=this.getServletContext();
        application.setAttribute("status","登入");
        application.setAttribute("url","login.jsp");
        CategoryService cs=new CategoryService();
        List<Category> list=cs.findAllCategorys();
        application.setAttribute("categorylist",list);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
