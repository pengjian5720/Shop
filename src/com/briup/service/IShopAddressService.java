package com.briup.service;

import java.util.List;

import com.briup.bean.ShopAddress;

public interface IShopAddressService {
	//根据用户ID查找收货地址
	List<ShopAddress> findAddressByCustomerId(Integer id);
	//新增收货地址
	void saveAddress(ShopAddress sd);
	//通过id查询收货地址
	ShopAddress findShopAddressById(Integer id);
}
