package com.scp.controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.scp.beans.Address;

public class AddressRestAPI {

	static String BASE_URI ="http://localhost:8080/bankapi-rest/bank/address/";
	public static void main(String[] args) {
		//List<Address> allAddress = getAllAddress();
		
		//System.out.println(allAddress);
		Address singleAddress = getSingleAddress(2);
		System.out.println(singleAddress);
	}
	
	public static List<Address> getAllAddress() {
		Response responce = RestAssured.get(BASE_URI);
		JSONArray addresses = new JSONArray(responce.asString());
		List<Address> addressList = new ArrayList<Address>();
		Address address=null;
		for (Object object : addresses) {
			JSONObject jsonOb = (JSONObject)object;
			address=new Address(jsonOb.getInt("addressId"),jsonOb.getString("city"));
			addressList.add(address);
		}
		return addressList;
	}
	
	public static Address getSingleAddress(int addressId){
		Response responce = RestAssured.get(BASE_URI+addressId);
		JSONObject jsonOb = new JSONObject(responce.asString());
		Address address = new Address(jsonOb.getInt("addressId"), jsonOb.getString("city"));
		System.out.println(address);
		return address;
	}
}
