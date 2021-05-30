package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册请求处理Servlet类
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setPassword(request.getParameter("password"));
        customer.setAddress(request.getParameter("address"));
        customer.setZipCode(request.getParameter("zipCode"));
        customer.setTelephone(request.getParameter("telephone"));
        customer.setEmail(request.getParameter("email"));
        CustomerServiceImpl registerService = new CustomerServiceImpl();
        //注册用户，如果注册成功则跳转到登入页，注册失败则返回注册页
        if(registerService.register(customer)){
            response.sendRedirect("login.jsp");
        }
        else {
            response.sendRedirect("register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
