package com.briup.web.servlet;
import com.briup.bean.Customer;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet("/loginServlet")
public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
