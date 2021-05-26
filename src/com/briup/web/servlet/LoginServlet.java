package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.service.serviceClass.LoginService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        LoginService service=new LoginService();
        Customer customer=service.login(name, password);
        if(customer.getName().equals(name)){
            HttpSession session= request.getSession(true);
            session.setAttribute("customer",customer);
            request.getRequestDispatcher("index.jsp").forward(request,response);

//            response.sendRedirect("index.jsp");
        }
        else {
/*            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.sendRedirect("login.jsp?error= your name or password is error");*/
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
