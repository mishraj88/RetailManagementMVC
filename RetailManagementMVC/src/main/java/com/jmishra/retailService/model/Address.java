package com.jmishra.retailService.model;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Address {

	String shopNumber;
	String shopStreet;
	String shopcity;
	String latitude;
	String longitude;
	
	
	public Address(){
		
	}
	
	public Address(String shopNumber, String shopStreet, String shopcity)  {
		super();
		this.shopNumber = shopNumber;
		this.shopStreet = shopStreet;
		this.shopcity = shopcity;
		try {
			String[] arr = getLatLongPositions(shopStreet+", "+shopcity);
			this.latitude = arr[0];
			this.longitude = arr[1];
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Address [shopNumber=" + shopNumber + ", shopStreet=" + shopStreet + ", shopcity=" + shopcity +
				", latitude= "+latitude+
				", longitude= "+longitude+
				"]";
	}
	
	public  String[] getLatLongPositions(String address) throws Exception
	{
		String[] latLongArr = new String[2];
		//address.replace(", ", ",+");
		//address.replace(" ", "+");
		int responseCode = 0;
		String api = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + 
								URLEncoder.encode(address, "UTF-8")/*address*/ + "&sensor=false"+"&key=AIzaSyCU-hlEluFTGR6w0X79zneXL-qwpf7Bkvk";
		URL url = new URL(api);
		HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();
		httpConnection.connect();
		responseCode = httpConnection.getResponseCode();
		if(responseCode == 200)
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
			Document document = builder.parse(httpConnection.getInputStream());
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile("/GeocodeResponse/status");
			String status = (String)expr.evaluate(document, XPathConstants.STRING);
			if(status.equals("OK"))
			{
				expr = xpath.compile("//geometry/location/lat");
				latitude = (String)expr.evaluate(document, XPathConstants.STRING);
				expr = xpath.compile("//geometry/location/lng");
				longitude = (String)expr.evaluate(document, XPathConstants.STRING);
				

			}
			else
			{
				throw new Exception("Error from the API - response status: "+status);
			}
		}
		else{
			longitude = null;
			latitude = null;
		}
		
		latLongArr[0] = latitude;
		latLongArr[1]=longitude;
		
		return latLongArr;

	}
	
	
	
	
}
