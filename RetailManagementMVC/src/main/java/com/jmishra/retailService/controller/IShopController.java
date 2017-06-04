package com.jmishra.retailService.controller;

import java.util.List;

import com.jmishra.retailService.model.Shop;

public interface IShopController {
	
	List<Shop> getAllShops();
	Shop addShop(Shop newShop);
	Shop getAShopDetails(String shopId);
	String updateShopDetails(String shopId, Shop updatedShop);
	String removeShopFromShopList(String shopId);

}
