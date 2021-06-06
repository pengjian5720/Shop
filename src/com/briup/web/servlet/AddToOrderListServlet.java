package com.briup.web.servlet;

import com.briup.bean.*;
import com.briup.service.impl.OrderFormServiceImpl;
import com.briup.service.impl.OrderLineServiceImpl;
import com.briup.service.impl.ShopAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@WebServlet("/AddToOrderListServlet")
public class AddToOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
//        Customer customer = (Customer) session.getAttribute("customer");
//        System.out.println("sessionId"+session.getId());
//        System.out.println("从session中获取用户id"+ customer.getId());
        OrderForm orderForm = new OrderForm();
        ShopCar shopCar = (ShopCar) session.getAttribute("shopCar");
        orderForm.setCost(shopCar.getCost());
        orderForm.setCustomer((Customer) session.getAttribute("customer"));
        //获取当前时间
        Date date = new Date();
        orderForm.setOrderdate(date);
        orderForm.setOrderLines(shopCar.getOrderLines());
        ShopAddressServiceImpl shopAddressService=new ShopAddressServiceImpl();
        //System.out.println("用户id："+orderForm.getCustomer().getId());
        List<ShopAddress> shopAddressList = shopAddressService.findAddressByCustomerId(orderForm.getCustomer().getId());
        orderForm.setShopAddress(shopAddressList.get(0));
        OrderFormServiceImpl orderFromService = new OrderFormServiceImpl();
        orderFromService.saveOrderForm(orderForm);
        Collection<OrderLine> orderLineList=orderForm.getOrderLines();
        OrderLineServiceImpl orderLineService=new OrderLineServiceImpl();
        for (OrderLine ol:orderLineList) {
            orderLineService.saveOrderLine(ol);
        }
        request.getRequestDispatcher("DisplayOrderListServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
