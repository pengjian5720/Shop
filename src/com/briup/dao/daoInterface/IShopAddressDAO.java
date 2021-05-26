package com.briup.dao.daoInterface;

import java.util.List;

import com.briup.bean.ShopAddress;

public interface IShopAddressDAO {
	List<ShopAddress> findAddressByCustomerId(Integer id);
	void saveAddress(ShopAddress sd);
	ShopAddress findShopAddressById(Integer id);
}
