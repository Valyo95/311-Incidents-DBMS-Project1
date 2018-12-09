package com.incidents.web;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.AbandonedVehicles;
import com.incidents.entities.MyUser;
import com.incidents.entities.TreeTrims;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.services.Users;
import com.incidents.services.impl.AbandonedVehiclesService;
import com.incidents.services.impl.TreeTrimsService;

@RestController
public class AbandonedVehiclesEndpoint {

	  @Autowired
	  private Users userService;
	  
	  @Autowired
	  private AbandonedVehiclesService service;
	  
	  @RequestMapping(value = "/abandonedVehiclesEndpoint/create", method = RequestMethod.POST, headers = "Accept=application/json")
	  public AbandonedVehicles create(Principal principal, @RequestParam("status") String status, @RequestParam("streetAddress") String streetAddress, @RequestParam("xCoordinate") Integer xCoordinate,
			  @RequestParam("yCoordinate") Integer yCoordinate, @RequestParam("ward") Integer ward, @RequestParam("policeDistrict") Integer policeDistrict, @RequestParam("communityArea") Integer communityArea, @RequestParam("latitude") Integer latitude, @RequestParam("longitude") Integer longitude,
			  @RequestParam("location") String location, @RequestParam("licensePlate") String licensePlate, @RequestParam("model") String model, @RequestParam("color") String color, @RequestParam("currentActivity") String currentActivity, @RequestParam("mostRecentAction") String mostRecentAction, @RequestParam("daysAbandoned") Integer daysAbandoned, @RequestParam("ssa") String ssa) {
		  MyUser user;
		  
		    if (principal != null) {
		        try {
		          user = userService.findByUsername(principal.getName());
		        } catch (EntityNotFoundException e) {
		          return null;
		        }
		      } else {
		        return null;
		      }
		    
		    return service.create(status, streetAddress, xCoordinate, yCoordinate, ward, policeDistrict, communityArea, latitude, longitude, location, licensePlate, model, color, currentActivity, mostRecentAction, daysAbandoned, ssa);
		    
	  }
	
}
