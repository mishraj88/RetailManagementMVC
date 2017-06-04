package com.jmishra.retailService.model;

public class Address {

	String shopNumber;
	String shopStreet;
	String shopcity;
	
	public Address(){
		
	}
	
	public Address(String shopNumber, String shopStreet, String shopcity) {
		super();
		this.shopNumber = shopNumber;
		this.shopStreet = shopStreet;
		this.shopcity = shopcity;
	}

	public String getShopNumber() {
		return shopNumber;
	}

	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}

	public String getShopStreet() {
		return shopStreet;
	}

	public void setShopStreet(String shopStreet) {
		this.shopStreet = shopStreet;
	}

	public String getShopcity() {
		return shopcity;
	}

	public void setShopcity(String shopcity) {
		this.shopcity = shopcity;
	}

	@Override
	public String toString() {
		return "Address [shopNumber=" + shopNumber + ", shopStreet=" + shopStreet + ", shopcity=" + shopcity + "]";
	}
	
	
	
	
	
}
