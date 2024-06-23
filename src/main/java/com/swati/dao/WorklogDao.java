package com.swati.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.swati.entities.Vehicle;
import com.swati.entities.Worklog;

@Component
public class WorklogDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer addWorklog(Worklog worklog)
	{
		Integer i = (Integer) hibernateTemplate.save(worklog);
		return i;
	}
	
	@Transactional
	public void deleteWorklog(int logId)
	{
		Vehicle vehicle = hibernateTemplate.get(Vehicle.class,logId);
		hibernateTemplate.delete(vehicle);
		
	}
	
	public List<Worklog> getAllWorklog()
	{
		List<Worklog> worklogList = hibernateTemplate.loadAll(Worklog.class);
		return worklogList;
	}
	
	public Worklog viewOneWorklog(int logId)
	{
		Worklog worklog = this.hibernateTemplate.get(Worklog.class,logId);
		return worklog;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public WorklogDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public WorklogDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
