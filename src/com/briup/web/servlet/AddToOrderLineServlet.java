package com.briup.web.servlet;

import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.service.impl.OrderFormServiceImpl;
import com.briup.service.impl.OrderLineServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebServlet("/AddToOrderLineServlet")
public class AddToOrderLineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long orderFormId=(long)Integer.parseInt(request.getParameter("orderForm"));
        OrderFormServiceImpl orderFormService=new OrderFormServiceImpl();
        OrderForm orderForm=orderFormService.findOrderFormByOrderid(orderFormId);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
