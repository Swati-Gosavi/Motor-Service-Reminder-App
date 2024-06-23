package com.swati.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.swati.entities.Garage;
import com.swati.entities.Vehicle;

@Component
public class GarageDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public String addGarage(Garage garage)
	{
		String s = (String) hibernateTemplate.save(garage);
		return s;
	}
	
	public List<Garage> getAllGarage()
	{
		List<Garage> garageList = hibernateTemplate.loadAll(Garage.class);
		return garageList;
	}
	
	@Transactional
	public void deleteGarage(String contact)
	{
		Garage garage = hibernateTemplate.get(Garage.class,contact);
		hibernateTemplate.delete(garage);
		
	}
	
	public Garage viewGarage(String contact)
	{
		Garage garage = this.hibernateTemplate.get(Garage.class,contact);
		return garage;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public GarageDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public GarageDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
