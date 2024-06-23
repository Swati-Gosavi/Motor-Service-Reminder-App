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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.swati.dao.VehicleDao;
import com.swati.dao.WorklogDao;
import com.swati.entities.Garage;
import com.swati.entities.Vehicle;
import com.swati.entities.Worklog;

@Controller
public class VehicleController {

	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	Vehicle vehicle = (Vehicle) context.getBean("vehicle");
    VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleDao");
    Worklog worklog = (Worklog) context.getBean("worklog");
    WorklogDao worklogDao = (WorklogDao) context.getBean("worklogDao");
    
    @RequestMapping("/")
    public String vehicleLoginPage() {
        System.out.println("Opening vehicle login page...");
        return "index"; 
    }
    
    @RequestMapping("/vehicleHomePage")
	   public String garageHome()
	   {
		   return "vehicleHomePage";
	   }
    
    @RequestMapping("/afterVehicleLogin")
    public String vehicleLogin(HttpServletRequest request, Model model) {
    	String vehicleNo = request.getParameter("vno"); 
        String email = request.getParameter("email"); 
        String password = request.getParameter("password"); 
        System.out.println("Email: "+email + " Password : "+password);
         vehicle = vehicleDao.viewVehicle(vehicleNo);
        if(vehicle!=null && vehicle.getEmail().equals(email) && vehicle.getVehiclePassword().equals(password))
        {
        	System.out.println("Vehicle Login Successful");
        	return "vehicleHomePage";
        }
        else
        {
        	System.out.println("Vehicle Login Failed");
        	return "index";
        }
        
    }
    
    @RequestMapping("/vehicleRegistration")
	public String vehicleRegisterPage()
	{
		return "vehicleRegister";
	}

    @RequestMapping("/afterVehicleRegistration")
    public String vehicleRegistration(HttpServletRequest request, Model model) {
        
        String vehicleNo = request.getParameter("vehicleNo");
        String chassisNo = request.getParameter("chassisNo");
        String name = request.getParameter("name"); 
        String ownerName = request.getParameter("ownerName"); 
        String contact = request.getParameter("contact"); 
        String address = request.getParameter("address"); 
        String email = request.getParameter("email"); 
        String vehiclePassword = request.getParameter("password"); 
        
        Vehicle newVehicle = new Vehicle(); 
        newVehicle.setVehicleNo(vehicleNo);
        newVehicle.setChassisNo(chassisNo);
        newVehicle.setName(name);
        newVehicle.setOwnerName(ownerName);
        newVehicle.setContact(contact);
        newVehicle.setAddress(address);
        newVehicle.setEmail(email);
        newVehicle.setVehiclePassword(vehiclePassword);

        try {
            String s = vehicleDao.addVehicle(newVehicle); 
            System.out.println("Registration Successful");
            return "vehicleHomePage";
        } catch (Exception e) {
            System.out.println("Registration failed");
            e.printStackTrace();
            return "index";
        }
    }
    
   
	
	@RequestMapping(path="/viewWorkLogForVehicle",method=RequestMethod.GET)
	public String getWorkLogsForVehicle(Model model, HttpServletRequest request)
	{
		//String vehicleNo = request.getParameter("vehicleNo");
		String vehicleNo = vehicle.getVehicleNo();
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
		return "viewWorkLogForVehicle";
	}
    
   @RequestMapping(path="/deleteVehicleWorklog/{logId}", method=RequestMethod.GET)
	public RedirectView deleteVehicleWorklog(@PathVariable("logId") int logId, HttpServletRequest request)
	{
		worklogDao.deleteWorklog(logId);
		
		RedirectView redirectView = new RedirectView();
		
		redirectView.setUrl(request.getContextPath()+"/vehicleHomePage");
		return redirectView;
	}
   
   @RequestMapping(path="/viewNearbyExpiryWorkLogForVehicle",method=RequestMethod.GET)
   public String viewNearbyExpiries(Model m,HttpServletRequest request) {
	   String vehicleNo = vehicle.getVehicleNo();
       List<Worklog> worklogList = worklogDao.getAllWorklog();
       List<Worklog> myWorkLog = new ArrayList<Worklog>();
       LocalDate currentDate = LocalDate.now();
       System.out.println("Current Date : "+currentDate);
       LocalDate newDate = currentDate.plusMonths(1);
       System.out.println("Next Month : "+newDate);
       
       for (Worklog w : worklogList) {
    	   if(w.getVehicleNo().equals(vehicleNo)){
	           LocalDate dueDate = LocalDate.parse(w.getDueDate()); 
	           long daysDifference = ChronoUnit.DAYS.between(currentDate, dueDate);
	           System.out.println("difference : "+daysDifference);
	           if (daysDifference >= -1 && daysDifference <= 30) { 
	               myWorkLog.add(w);
	           }
           }
       }
       m.addAttribute("myWorkLog",myWorkLog);
       System.out.println(myWorkLog);
       
       return "viewNearbyExpiryWorkLogForVehicle"; 
   }

   
   @RequestMapping(path="/viewExpiredWorkLogForVehicle",method=RequestMethod.GET)
   public String viewExpiredWorkLog(Model m,HttpServletRequest request)
   {
	   String vehicleNo = vehicle.getVehicleNo();
	   List<Worklog> worklogList = worklogDao.getAllWorklog();
       List<Worklog> myWorkLog = new ArrayList<Worklog>();
       
       
       
       LocalDate currentDate = LocalDate.now();
       System.out.println("Current Date : "+currentDate);
       
       for (Worklog w : worklogList) {
    	   if(w.getVehicleNo().equals(vehicleNo))
    	   {
		       LocalDate dueDate = LocalDate.parse(w.getDueDate()); 
		       int result = currentDate.compareTo(dueDate);
		       System.out.println("result : "+result);
		       if (result > 0) { 
		           myWorkLog.add(w);
		       }
    	   }
       }
       
       m.addAttribute("myWorkLog",myWorkLog);
       
      
       return "viewExpiredWorkLogForVehicle"; 
   }
   
    
    

}
