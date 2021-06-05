package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.service.impl.OrderFormServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DisplayOrderListServlet")
public class DisplayOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
        List<OrderForm> formList = new ArrayList<OrderForm>();
        OrderFormServiceImpl orderFormService=new OrderFormServiceImpl();
        formList=orderFormService.findOrderFormByCustomerId(customer.getId());
        request.setAttribute("formList",formList);
        request.getRequestDispatcher("privatePage/orderlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
