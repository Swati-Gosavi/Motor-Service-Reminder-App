package com.swati.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.swati.dao.GarageDao;
import com.swati.dao.VehicleDao;
import com.swati.entities.Garage;
import com.swati.entities.Vehicle;

@Controller
public class AdminController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Garage garage = (Garage) context.getBean("garage");
    GarageDao garageDao = (GarageDao) context.getBean("garageDao");
    Vehicle vehicle = (Vehicle) context.getBean("vehicle");
    VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
	
	 @RequestMapping("/adminLoginPage")
	    public String adminLoginPage() {
	        System.out.println("Opening admin login page...");
	        return "adminLogin"; 
	    }

	    @RequestMapping("/afterAdminLogin")
	    public String adminLogin(HttpServletRequest request) 
	    {
	    	System.out.println("calling after admin login");
	    	String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println("Email: "+email + " Password : "+password);
			
			if(email.equals("admin@gmail.com") && password.equals("admin"))
			{
				System.out.println("Login Successfully, opening admin home page..");
				return "adminHome";
			}
			else
			{
				System.out.println("Login Failed");
				return "adminLogin";
			}
	    }
	    
	    @RequestMapping("/adminHome")
	    public String adminHomePage()
	    {
	    	return "adminHome";
	    }
	    
	    @RequestMapping("/afterAdminHomeForView")
	    public String afterAdminHomePageForview(Model m)
	    {
	    	List<Garage> garage = garageDao.getAllGarage();
			m.addAttribute("garageList",garage);
	    	return "viewAllGarage";
	    }
	    
	    @RequestMapping(path="/deleteGarage/{contact}", method=RequestMethod.GET)
		public RedirectView deleteGarage(@PathVariable("contact") String contact, HttpServletRequest request)
		{
			garageDao.deleteGarage(contact);
			
			RedirectView redirectView = new RedirectView();
			
			redirectView.setUrl(request.getContextPath()+"/adminHome");
			return redirectView;
			
		}
	    
	    
	    
	    @RequestMapping("/getVehicleNo")
		public String getVehicleNo()
		{
			return "getVehicleNo";
		}
		
		@RequestMapping(path="/searchVehicle",method=RequestMethod.POST)
		public String getVehicle(Model model, HttpServletRequest request)
		{
			String vehicleNo = request.getParameter("vehicleNo");
			System.out.println(vehicleNo);
			vehicle = vehicleDao.viewVehicle(vehicleNo);
			System.out.println(vehicle.toString());
			model.addAttribute("vehicle",vehicle);
			return "searchVehicle";
		}
	    
	   @RequestMapping(path="/deleteVehicle/{vehicleNo}", method=RequestMethod.GET)
		public RedirectView deleteVehicle(@PathVariable("vehicleNo") String vehicleNo, HttpServletRequest request)
		{
			vehicleDao.deleteVehicle(vehicleNo);
			
			RedirectView redirectView = new RedirectView();
			
			redirectView.setUrl(request.getContextPath()+"/adminHome");
			return redirectView;
		}
	    
}
