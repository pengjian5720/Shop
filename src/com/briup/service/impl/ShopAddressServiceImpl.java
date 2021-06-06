package com.briup.service.impl;

import com.briup.bean.ShopAddress;
import com.briup.dao.IShopAddressDAO;
import com.briup.dao.impl.ShopAddressDAOImpl;

import java.util.List;

public class ShopAddressServiceImpl implements IShopAddressDAO {
    ShopAddressDAOImpl shopAddressDAO = new ShopAddressDAOImpl();
    @Override
    public List<ShopAddress> findAddressByCustomerId(Integer id) {
        return shopAddressDAO.findAddressByCustomerId(id);
    }

    @Override
    public void saveAddress(ShopAddress sd) {
        shopAddressDAO.saveAddress(sd);
    }

    @Override
    public ShopAddress findShopAddressById(Integer id) {
        return shopAddressDAO.findShopAddressById(id);
    }
}
