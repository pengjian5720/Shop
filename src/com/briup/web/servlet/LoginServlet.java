package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.service.impl.CustomerServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登入请求处理Servlet类
 */
@WebServlet("/loginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        CustomerServiceImpl service=new CustomerServiceImpl();
        //调用service层方法验证用户名和密码是否正确
        Customer customer=service.login(name, password);
        if(customer!=null){
            HttpSession session= request.getSession(true);
            //将用户信息保存到session中
            session.setAttribute("customer",customer);
            ServletContext application = this.getServletContext();
            application.setAttribute("status", "退出");
            application.setAttribute("url","exitServlet");
            //登入成功，跳转到DefaultInfoDisplayServlet
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else {
            request.setAttribute("error","用户名或密码错误");
            //登入失败，跳转到登入页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
