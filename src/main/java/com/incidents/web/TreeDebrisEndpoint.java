package com.incidents.web;

import java.security.Principal;
import java.util.Date;

import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.MyUser;
import com.incidents.entities.TreeDebris;
import com.incidents.entities.TreeTrims;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.services.Users;
import com.incidents.services.impl.TreeDebrisService;
import com.incidents.services.impl.TreeTrimsService;

@RestController
public class TreeDebrisEndpoint {

	  @Autowired
	  private Users userService;
	  
	  @Autowired
	  private TreeDebrisService service;
	  
	  @RequestMapping(value = "/treeDebrisEndpoint/create", method = RequestMethod.POST, headers = "Accept=application/json")
	  public TreeDebris create(Principal principal, @RequestParam("status") String status, @RequestParam("streetAddress") String streetAddress, @RequestParam("zipCode") String zipCode, @RequestParam("xCoordinate") Double xCoordinate,
			  @RequestParam("yCoordinate") Double yCoordinate, @RequestParam("ward") Integer ward, @RequestParam("policeDistrict") Integer policeDistrict, @RequestParam("communityArea") Integer communityArea, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude,
			  @RequestParam("location") String location, @RequestParam("location2") String location2, @RequestParam("currentActivity") String currentActivity, @RequestParam("mostRecentAction") String mostRecentAction) {
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
		    
		    return service.create(status, streetAddress, zipCode , xCoordinate, yCoordinate, ward, policeDistrict, communityArea, latitude, longitude, location, location2, currentActivity, mostRecentAction);
		    
	  }
	
}
