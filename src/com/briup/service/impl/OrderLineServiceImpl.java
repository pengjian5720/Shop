package com.briup.service.impl;

import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.dao.IOrderLineDAO;
import com.briup.dao.impl.OrderLineDAOImpl;
import com.briup.service.IOrderFormService;
import com.briup.service.IOrderLineService;

import java.util.List;

public class OrderLineServiceImpl implements IOrderLineService {
    @Override
    public void saveOrderLine(OrderLine ol) {
        OrderLineDAOImpl orderLineDAO=new OrderLineDAOImpl();
        orderLineDAO.saveOrderLine(ol);
    }

    @Override
    public List<OrderLine> findOrderLineByOrderId(Integer id) {
        return null;
    }
}
