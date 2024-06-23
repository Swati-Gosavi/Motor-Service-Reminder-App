package com.swati.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Worklog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int logId;
	private String vehicleNo;
	private String title;
	private String description;
	private String date;
	private String time;
	private String email;
	private String contact;
	private String address;
	private String garageContact;
	private String dueDate;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGarageContact() {
		return garageContact;
	}
	public void setGarageContact(String garageContact) {
		this.garageContact = garageContact;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public Worklog(int logId, String vehicleNo, String title, String description, String date, String time,
			String email, String contact, String address, String garageContact, String dueDate) {
		super();
		this.logId = logId;
		this.vehicleNo = vehicleNo;
		this.title = title;
		this.description = description;
		this.date = date;
		this.time = time;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.garageContact = garageContact;
		this.dueDate = dueDate;
	}
	public Worklog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Worklog [logId=" + logId + ", vehicleNo=" + vehicleNo + ", title=" + title + ", description="
				+ description + ", date=" + date + ", time=" + time + ", email=" + email + ", contact=" + contact
				+ ", address=" + address + ", garageContact=" + garageContact + ", dueDate=" + dueDate + "]";
	}
		
}
