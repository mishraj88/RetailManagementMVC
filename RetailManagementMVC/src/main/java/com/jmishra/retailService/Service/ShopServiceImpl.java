package com.jmishra.retailService.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jmishra.retailService.model.Address;
import com.jmishra.retailService.model.Shop;
import org.springframework.stereotype.Service;



@Service
public class ShopServiceImpl implements IShopService {

	private List<Shop> shopList = new ArrayList<Shop>(Arrays.asList(new Shop("MyFashionStop", new Address("15A","Green Park Market","New Delhi")),
			new Shop("MyShoeStop", new Address("11A","South Extension Market","New Delhi")),
			new Shop("MyGeekyStop", new Address("15/26-PoketA","Nehru Place","New Delhi")),
			new Shop("MyGameStop", new Address("209B","Cannaught Place","New Delhi"))));
	
	
	@Override
	public List<Shop> getAllShops() {
		synchronized(shopList){
			return shopList;
		}
	}

	@Override
	public Shop getAShopDetails(String shopId) {
		synchronized(shopList){
			return shopList.stream().filter(t -> t.getId().equals(shopId)).findAny().get();
		}
	}

	@Override
	public Shop addShop(Shop newShopDetails) {
		synchronized(shopList){
			shopList.add(newShopDetails);
		}
		return newShopDetails;
	}

	@Override
	public Shop updateShop(String shopId, Shop updatedShopDetails) {
		Shop oldShopDetails;
		synchronized(shopList){
			oldShopDetails = shopList.stream().filter(t -> t.getId().equals(shopId)).findFirst().get();
		
			for(int i=0; i<shopList.size(); i++){
				if(shopList.get(i).getId().equals(shopId))
					shopList.set(i, updatedShopDetails);
			}
		}
		return oldShopDetails;
		
	}

	@Override
	public Shop removeShop(String shopId) {
		Shop oldShopDetails;
		synchronized(shopList){
		oldShopDetails = shopList.stream().filter(t -> t.getId().equals(shopId)).findFirst().get();
		
		shopList.removeIf(t -> t.getId().equals(shopId));
		}
		return oldShopDetails;
	}

}
