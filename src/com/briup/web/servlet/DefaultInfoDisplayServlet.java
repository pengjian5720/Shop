package com.briup.web.servlet;

import com.briup.bean.Category;
import com.briup.service.impl.CategoryServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 首页加载时需要的信息展示Servlet类
 */
@WebServlet("/DefaultInfoDisplayServlet")
public class DefaultInfoDisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application=this.getServletContext();
        application.setAttribute("status","注销");
        application.setAttribute("url","login.jsp");
        CategoryServiceImpl cs=new CategoryServiceImpl();
        //获取所有商品分类信息
        List<Category> list=cs.findAllCategories();
        //将商品分类信息保存到上下文对象
        application.setAttribute("categorylist",list);
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
