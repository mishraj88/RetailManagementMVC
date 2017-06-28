package com.jmishra.retailService.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmishra.retailService.Service.ShopServiceImpl;
import com.jmishra.retailService.model.Shop;

@RestController
public class ShopServiceController implements IShopController {

	@Autowired
	private ShopServiceImpl shopService;
	
	@Override
	@RequestMapping("/shops")
	public Map<String,Shop> getAllShops() {
		
		return shopService.getAllShops();
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value="/shops")
	public Shop addShop(@RequestBody Shop newShop) {
		Shop newShopDetails=shopService.addShop(newShop);
		return newShopDetails;
	}

	@Override
	@RequestMapping("/shops/{shopId}")
	public Shop getAShopDetails(@PathVariable String shopId) {
		Shop shop=shopService.getAShopDetails(shopId);
		return shop;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value="/shops/{shopId}")
	public String updateShopDetails(@PathVariable String shopId, @RequestBody Shop updatedShop) {
		Shop oldShopDetails = shopService.updateShop(shopId, updatedShop);
		if(oldShopDetails!=null)
		return "oldShopDetails : \n\n"+oldShopDetails.toString()+ "\n\n has changed to \n\n newShopDetails: \n\n"+updatedShop.toString();
		else
			return "no shop with the given shop id in request";
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value="/shops/{shopId}")
	public String removeShopFromShopList(@PathVariable String shopId) {
		Shop removedShop = shopService.removeShop(shopId);
		if(removedShop != null)
		return "removedShop details: \n\n"+removedShop.toString();
		else{
			return "this shop doesn't exist in the shopList";
		}
	}

}
