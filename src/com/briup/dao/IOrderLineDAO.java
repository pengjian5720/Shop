package com.briup.dao;

import java.util.Collection;
import java.util.List;

import com.briup.bean.OrderLine;

public interface IOrderLineDAO {
	void saveOrderLine(OrderLine ol);
	List<OrderLine> findOrderLineByOrderId(Integer id);
	
	void deleteOrderLineByCollection(Collection<OrderLine> orderLines);
	
}
