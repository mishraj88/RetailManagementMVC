package com.jmishra.retailService.Service;

import java.util.List;
import java.util.Map;

import com.jmishra.retailService.model.Shop;

interface IShopService {

	/*
	 * This method's implementation returns all the shops from the inventory
	 */
	Map<String,Shop> getAllShops();
	
	/*
	 * This methods implementation would return details for a particular shop
	 */
	Shop getAShopDetails(String shopId);
	
	//This method implementation would add a new Shop to the Shop inventory
	Shop addShop(Shop newShopDetails);
	//This shop would update the details of a shop with the provided Shop ID
	Shop updateShop(String shopId, Shop updatedShopDetails);
	//This method is called by the controller to remove a Shop from the inventory
	Shop removeShop(String shopId);
	
}
