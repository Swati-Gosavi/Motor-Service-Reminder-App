package com.swati.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import com.swati.entities.Vehicle;

@Component
public class VehicleDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public String addVehicle(Vehicle vehicle)
	{
		String s =  (String) hibernateTemplate.save(vehicle);
		return s;
	}
	
	public List<Vehicle> getAllVehicle()
	{
		List<Vehicle> vehicleList = hibernateTemplate.loadAll(Vehicle.class);
		return vehicleList;
	}
	
	public Vehicle viewVehicle(String vno)
	{
		Vehicle vehicle = this.hibernateTemplate.get(Vehicle.class,vno);
		System.out.println(vehicle.toString());
		return vehicle;
	}
	
	@Transactional
	public void deleteVehicle(String vehicleNo)
	{
		Vehicle vehicle = hibernateTemplate.get(Vehicle.class,vehicleNo);
		hibernateTemplate.delete(vehicle);
		
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public VehicleDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public VehicleDao() {
		super();
		// TODO Auto-generated constructor stub
	}

}
