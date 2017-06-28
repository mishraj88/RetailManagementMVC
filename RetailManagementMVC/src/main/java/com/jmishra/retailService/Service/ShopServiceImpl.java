package com.jmishra.retailService.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jmishra.retailService.model.Address;
import com.jmishra.retailService.model.Shop;
import org.springframework.stereotype.Service;

/*
 * This is a Service class which basically is responsible for creating Shop class' Object
 * I am using a HashMap<String shop_id, Shop shopObj> as an in memory internal storage
 * as I was having some trouble resolving gradle dependency for apache derby database
 * This class also has all the rootLevel methods which would directly interact with the dataStructure
 * and pull out or execute the requested Operation.
 */

@Service
public class ShopServiceImpl implements IShopService {


	private static HashMap<String, Shop> shopMap = new HashMap<String, Shop>();

	static{

		try {
			Shop shop1 = new Shop("MyFashionStop", new Address("15A","Green Park","New Delhi"));

			Shop shop2=new Shop("MyShoeStop", new Address("11A","South Extension","New Delhi"));
			Shop shop3=new Shop("MyGeekyStop", new Address("15/26","Nehru Place","New Delhi"));
			Shop shop4= new Shop("MyGameStop", new Address("209B","Connaught Place","New Delhi"));	

			shopMap.put(shop1.getId(), shop1);
			shopMap.put(shop2.getId(), shop2);
			shopMap.put(shop3.getId(), shop3);
			shopMap.put(shop4.getId(), shop4);
		} catch (Exception e) {

			e.printStackTrace();
		}



	}


	/*
	 * (non-Javadoc)
	 * @see com.jmishra.retailService.Service.IShopService#getAllShops()
	 */
	@Override
	public Map<String, Shop> getAllShops() {
		synchronized(shopMap){
			return shopMap;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jmishra.retailService.Service.IShopService#getAShopDetails(java.lang.String)
	 */

	@Override
	public Shop getAShopDetails(String shopId) {
		synchronized(shopMap){
			//return shopList.stream().filter(t -> t.getId().equals(shopId)).findAny().get();
			if(shopMap.containsKey(shopId)){
				return shopMap.get(shopId);
			}
			else return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jmishra.retailService.Service.IShopService#addShop(com.jmishra.retailService.model.Shop)
	 */
	
	@Override
	public Shop addShop(Shop newShopDetails) {
		synchronized(shopMap){

			shopMap.put(newShopDetails.getId(), newShopDetails);

		}
		return newShopDetails;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jmishra.retailService.Service.IShopService#updateShop(java.lang.String, com.jmishra.retailService.model.Shop)
	 */
	

	@Override
	public Shop updateShop(String shopId, Shop updatedShopDetails) {
		Shop oldShopDetails = null;
		synchronized(shopMap){
			if(shopMap.containsKey(shopId)){
				oldShopDetails = shopMap.get(shopId);
			}

			shopMap.put(shopId, updatedShopDetails);

		}
		return oldShopDetails;

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.jmishra.retailService.Service.IShopService#removeShop(java.lang.String)
	 */

	@Override
	public Shop removeShop(String shopId) {
		Shop oldShopDetails;
		synchronized(shopMap){
			oldShopDetails=shopMap.get(shopId);

			shopMap.remove(shopId);
		}
		return oldShopDetails;
	}

}
