package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.service.impl.OrderFormServiceImpl;
import com.briup.service.impl.ShopAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/AddToOrderListServlet")
public class AddToOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        OrderForm orderForm = new OrderForm();
        ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
        orderForm.setCost(shopCar.getCost());
        orderForm.setCustomer((Customer) session.getAttribute("customer"));
        //获取当前时间
        Date date = new Date();
        orderForm.setOrderdate(date);
        orderForm.setOrderLines(shopCar.getOrderLines());
        ShopAddressServiceImpl shopAddressService=new ShopAddressServiceImpl();
        List<ShopAddress> shopAddressList = shopAddressService.findAddressByCustomerId(((Customer) session.getAttribute("customer")).getId());
        orderForm.setShopAddress(shopAddressList.get(0));
        OrderFormServiceImpl orderFromService = new OrderFormServiceImpl();
        orderFromService.saveOrderForm(orderForm);
        request.setAttribute("orderFrom",orderForm.getId());
        request.getRequestDispatcher("AddToOrderLineServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
