package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.service.serviceClass.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

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
        RegisterService registerService = new RegisterService();
        Customer customer1 = registerService.findCustomerByName(request.getParameter("name"));
        if(customer1.getName().equals("")){
            registerService.register(customer);
            response.sendRedirect("login.jsp");
        }
        else {
            response.sendRedirect("register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
