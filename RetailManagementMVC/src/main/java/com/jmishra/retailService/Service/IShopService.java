package com.jmishra.retailService.Service;

import java.util.List;

import com.jmishra.retailService.model.Shop;

interface IShopService {

	List<Shop> getAllShops();
	Shop getAShopDetails(String shopId);
	Shop addShop(Shop newShopDetails);
	Shop updateShop(String shopId, Shop updatedShopDetails);
	Shop removeShop(String shopId);
	
}
