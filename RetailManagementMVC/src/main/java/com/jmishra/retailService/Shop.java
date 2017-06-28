package com.jmishra.retailService.model;

public class Shop {
	
	private static int count;
	
	private String id;
	private String shopName;
	Address shopAddress;
	
	
	public Shop(){
		
	}
	
	
	public Shop(String id, String shopName, Address shopAddress) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}


	public Shop(String shopName, Address shopAddress) {
		super();
		this.id ="Shop_"+(++count);
		this.shopName = shopName;
		this.shopAddress = shopAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Address getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}


	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + ", shopAddress=" + shopAddress.toString() + "]";
	}
	
	

}
