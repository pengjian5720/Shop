package com.briup.service.impl;

import com.briup.bean.ShopAddress;
import com.briup.dao.IShopAddressDAO;
import com.briup.dao.impl.ShopAddressDAOImpl;

import java.util.List;

public class ShopAddressServiceImpl implements IShopAddressDAO {
    @Override
    public List<ShopAddress> findAddressByCustomerId(Integer id) {
        return null;
    }

    @Override
    public void saveAddress(ShopAddress sd) {

    }

    @Override
    public ShopAddress findShopAddressById(Integer id) {
        ShopAddressDAOImpl shopAddressDAO=new ShopAddressDAOImpl();
        return shopAddressDAO.findShopAddressById(id);
    }
}
