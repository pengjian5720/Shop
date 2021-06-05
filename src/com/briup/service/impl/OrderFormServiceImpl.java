package com.briup.service.impl;

import com.briup.bean.OrderForm;
import com.briup.dao.impl.OrderFormDAOImpl;
import com.briup.service.IOrderFormService;

import java.util.List;

public class OrderFormServiceImpl implements IOrderFormService {

    @Override
    public void saveOrderForm(OrderForm of) {
        OrderFormDAOImpl orderFromDAO = new OrderFormDAOImpl();
        orderFromDAO.saveOrderForm(of);
    }

    @Override
    public OrderForm findOrderFormByOrderid(Long orderid) {
        return null;
    }

    @Override
    public List<OrderForm> findOrderFormByCustomerId(Integer id) {
        OrderFormDAOImpl orderFromDAO=new OrderFormDAOImpl();
        return orderFromDAO.findOrderFormByCustomerId(id);
    }

    @Override
    public void deleteOrderFormById(Integer id) {

    }
}

