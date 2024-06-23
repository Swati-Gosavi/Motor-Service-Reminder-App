package com.swati.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.swati.dao.GarageDao;
import com.swati.dao.VehicleDao;
import com.swati.dao.WorklogDao;
import com.swati.entities.Garage;
import com.swati.entities.Vehicle;
import com.swati.entities.Worklog;

@Controller
public class GarageController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Garage garage = (Garage) context.getBean("garage");
    GarageDao garageDao = (GarageDao) context.getBean("garageDao");
    Vehicle vehicle = (Vehicle) context.getBean("vehicle");
    VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
    Worklog worklog = (Worklog) context.getBean("worklog");
    WorklogDao worklogDao = (WorklogDao) context.getBean("worklogDao");
    
    
    @RequestMapping("/garageLoginPage")
    public String garageLoginPage() {
        System.out.println("Opening garage login page...");
        return "garageLogin"; 
    }
    
    @RequestMapping("/afterGarageLogin")
    public String garageLogin(HttpServletRequest request, Model model) {
    	String contact = request.getParameter("contact"); 
        String email = request.getParameter("email"); 
        String password = request.getParameter("password");
        System.out.println("Email: "+email + " Password : "+password);

        Garage garage = garageDao.viewGarage(contact);
        if(garage!=null && garage.getEmail().equals(email)&& garage.getGaragePassword().equals(password))
        {
        	System.out.println("Garage Login Successful");
        	return "garageHomePage";
        }
        else
        {
        	System.out.println("Garage Login Successful");
        	return "index";
        }

     }
    
    @RequestMapping("/garageRegistration")
	public String garageRegisterPage()
	{
		return "garageRegister";
	}

    @RequestMapping("/afterGarageRegistration")
    public String garageRegistration(HttpServletRequest request, Model model) {
        
        String contact = request.getParameter("contact"); 
        String name = request.getParameter("name"); 
        String address = request.getParameter("address"); 
        String pincode = request.getParameter("pincode"); 
        String email = request.getParameter("email");
        double latitude = Double.parseDouble(request.getParameter("latitude"));
        double longitude = Double.parseDouble(request.getParameter("longitude"));
        String garagePassword = request.getParameter("password"); 

        Garage newGarage = new Garage();
        newGarage.setContact(contact);
        newGarage.setName(name);
        newGarage.setAddress(address);
        newGarage.setPincode(pincode);
        newGarage.setEmail(email);
        newGarage.setLatitude(latitude);
        newGarage.setLongitude(longitude);
        newGarage.setGaragePassword(garagePassword);

        try {
            
            String s = garageDao.addGarage(newGarage);

            return "garageHomePage";
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
        
    }
    
        @RequestMapping("/getVehicleNoForSearchVehicle")
		public String getVehicleNoForSearch()
		{
			return "getVehicleNoForSearch";
		}
		
		@RequestMapping(path="/searchVehicleForGarage",method=RequestMethod.POST)
		public String getVehicleForGarage(Model model, HttpServletRequest request)
		{
			String vehicleNo = request.getParameter("vehicleNo");
			System.out.println(vehicleNo);
			vehicle = vehicleDao.viewVehicle(vehicleNo);
			System.out.println(vehicle.toString());
			model.addAttribute("vehicle",vehicle);
			return "viewVehicleForGarage";
		}
	    
	   @RequestMapping(path="/deleteVehicleForGarage/{vehicleNo}", method=RequestMethod.GET)
		public RedirectView deleteVehicleForGarage(@PathVariable("vehicleNo") String vehicleNo, HttpServletRequest request)
		{
			vehicleDao.deleteVehicle(vehicleNo);
			
			RedirectView redirectView = new RedirectView();
			
			redirectView.setUrl(request.getContextPath()+"/garageHomePage");
			return redirectView;
		}
	   
	   @RequestMapping("/garageHomePage")
	   public String garageHome()
	   {
		   return "garageHomePage";
	   }
	   
	   @RequestMapping("/addWorkLog")
		public String addWorkLogPage()
		{
			return "addWorkLog";
		}
		
		@RequestMapping(path="/afterAddWorkLogSubmit",method=RequestMethod.POST)
		public String afterAddWorkLog(@ModelAttribute Worklog worklog)
		{
			try
			{
				Integer i = worklogDao.addWorklog(worklog);
				System.out.println("Worklog Added..!!");
				return "garageHomePage";
			}
			catch(Exception e)
			{
				System.out.println("Failed to add..!!");
				e.printStackTrace();
				return "garageHomeError";
			}
		}
			
		@RequestMapping("/garageHomeError")
		public String errorPage()
		{
			return "garageHomeError";
		}
			
		@RequestMapping("/getVehicleNoForSearchWorkLog")
		public String getVehicleNoForWorkLog()
		{
			return "getVehicleNoForWorkLog";
		}
		
		@RequestMapping(path="/searchWorkLog",method=RequestMethod.POST)
		public String getWorkLog(Model model, HttpServletRequest request)
		{
			String vehicleNo = request.getParameter("vehicleNo");
			System.out.println(vehicleNo);
			
			List<Worklog> worklogList = worklogDao.getAllWorklog();
			List<Worklog> myWorkLog = new ArrayList<Worklog>();
			for(Worklog w : worklogList)
			{
				if(w.getVehicleNo().equals(vehicleNo))
				{
					myWorkLog.add(w);
				}
			}
			// new list - my vehicle no. log ==> myWorkLog
			System.out.println(worklogList.toString());
			model.addAttribute("worklogList",myWorkLog);
			return "searchWorkLog";
		}
	    
	   @RequestMapping(path="/deleteWorklog/{logId}", method=RequestMethod.GET)
		public RedirectView deleteWorklog(@PathVariable("logId") int logId, HttpServletRequest request)
		{
			worklogDao.deleteWorklog(logId);
			
			RedirectView redirectView = new RedirectView();
			
			redirectView.setUrl(request.getContextPath()+"/garageHomePage");
			return redirectView;
		}
	   
	   @RequestMapping(path="/viewNearbyExpiryWorkLogForGarage")
	   public String viewNearbyExpiries(Model m,HttpServletRequest request) {
		  
	       List<Worklog> worklogList = worklogDao.getAllWorklog();
	       List<Worklog> myWorkLog = new ArrayList<Worklog>();
	       LocalDate currentDate = LocalDate.now();
	       System.out.println("Current Date : "+currentDate);
	       LocalDate newDate = currentDate.plusMonths(1);
	       System.out.println("Next Month : "+newDate);
	       
	       for (Worklog w : worklogList) 
	       {
	    	   
		           LocalDate dueDate = LocalDate.parse(w.getDueDate()); 
		           long daysDifference = ChronoUnit.DAYS.between(currentDate, dueDate);
		           System.out.println("difference : "+daysDifference);
		           if (daysDifference >= -1 && daysDifference <= 30) 
		           { 
		               myWorkLog.add(w);
		           }
	          
	       }
	       m.addAttribute("myWorkLog",myWorkLog);
	       System.out.println(myWorkLog);
	       
	       return "viewNearbyExpiryWorkLogForGarage"; 
	   }

	   
	   @RequestMapping(path="/viewExpiredWorkLog")
	   public String viewExpiredWorkLog(Model m,HttpServletRequest request)
	   {   
		   
		   List<Worklog> worklogList = worklogDao.getAllWorklog();
	       List<Worklog> myWorkLog = new ArrayList<Worklog>();
	       LocalDate currentDate = LocalDate.now();
	       System.out.println("Current Date : "+currentDate);
	       
	       for (Worklog w : worklogList) 
	       {
	    	   
		           LocalDate dueDate = LocalDate.parse(w.getDueDate()); 
		           int result = currentDate.compareTo(dueDate);
		           System.out.println("result : "+result);
		           if (result > 0) 
		           { 
		               myWorkLog.add(w);
		           }
	          
	       }
	       m.addAttribute("myWorkLog",myWorkLog);
	       
	      
	       return "viewExpiredWorkLogForGarage"; 
	   }
	   
			
		
        
        
        
        
        
        
        
        
        
        
        
        
   


}
