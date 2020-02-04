package com.scp.beans;

public class Address {
	
	private int addressId;
	private String city;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int addressId, String city) {
		super();
		this.addressId = addressId;
		this.city = city;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + "]";
	}
	
	

	
}
