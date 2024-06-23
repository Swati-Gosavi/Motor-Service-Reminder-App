package com.swati.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Garage {
	
	@Id
	private String contact;
    private String name;
	private String address;
	private String pincode;
	private String email;
	private double latitude;
	private double longitude;
	private String garagePassword;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getGaragePassword() {
		return garagePassword;
	}
	public void setGaragePassword(String garagePassword) {
		this.garagePassword = garagePassword;
	}
	public Garage(String contact, String name, String address, String pincode, String email, double latitude,
			double longitude, String garagePassword) {
		super();
		this.contact = contact;
		this.name = name;
		this.address = address;
		this.pincode = pincode;
		this.email = email;
		this.latitude = latitude;
		this.longitude = longitude;
		this.garagePassword = garagePassword;
	}
	public Garage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Garage [contact=" + contact + ", name=" + name + ", address=" + address + ", pincode=" + pincode
				+ ", email=" + email + ", latitude=" + latitude + ", longitude=" + longitude + ", garagePassword="
				+ garagePassword + "]";
	}
	
	
	
	
}
