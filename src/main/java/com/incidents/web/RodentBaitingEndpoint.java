package com.incidents.web;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.MyUser;
import com.incidents.entities.RodentBaiting;
import com.incidents.entities.TreeTrims;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.repositories.RodentBaitingDAO;
import com.incidents.services.Users;
import com.incidents.services.impl.RodentBaitingService;
import com.incidents.services.impl.TreeTrimsService;

@RestController
public class RodentBaitingEndpoint {

	@Autowired
	private Users userService;

	@Autowired
	private RodentBaitingDAO rodentBaitingDAO;
	
	@Autowired
	private RodentBaitingService service;

	@RequestMapping(value = "/rodentBaitingEndpoint/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public RodentBaiting create(Principal principal, @RequestParam("status") String status,
			@RequestParam("streetAddress") String streetAddress, @RequestParam("zipCode") String zipCode,
			@RequestParam("xCoordinate") Double xCoordinate, @RequestParam("yCoordinate") Double yCoordinate,
			@RequestParam("ward") Integer ward, @RequestParam("policeDistrict") Integer policeDistrict,
			@RequestParam("communityArea") Integer communityArea, @RequestParam("latitude") Double latitude,
			@RequestParam("longitude") Double longitude, @RequestParam("location") String location,
			@RequestParam("premisesBaited") Double premisesBaited,
			@RequestParam("premisesWithGarbage") Double premisesWithGarbage,
			@RequestParam("premisesWithRats") Double premisesWithRats,
			@RequestParam("currentActivity") String currentActivity,
			@RequestParam("mostRecentAction") String mostRecentAction) {
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

		return service.create(status, streetAddress, zipCode, xCoordinate, yCoordinate, ward, policeDistrict,
				communityArea, latitude, longitude, location, premisesBaited, premisesWithGarbage, premisesWithRats,
				currentActivity, mostRecentAction);

	}

	@RequestMapping(value = "/rodentBaitingWithPremisesBaitedLessThan", method = RequestMethod.GET)
	public List<Object> rodentBaitingWithPremisesBaitedLessThan(Principal principal,
			@RequestParam("number") int number) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return rodentBaitingDAO.rodentBaitingWithPremisesBaitedLessThan(number);
	}
	
	@RequestMapping(value = "/rodentBaitingWithGarbagePremisesBaitedLessThan", method = RequestMethod.GET)
	public List<Object> rodentBaitingWithGarbagePremisesBaitedLessThan(Principal principal,
			@RequestParam("number") int number) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return rodentBaitingDAO.rodentBaitingWithGarbagePremisesBaitedLessThan(number);
	}

	
	@RequestMapping(value = "/rodentBaitingWithRatsPremisesBaitedLessThan", method = RequestMethod.GET)
	public List<Object> rodentBaitingWithRatsPremisesBaitedLessThan(Principal principal,
			@RequestParam("number") int number) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return rodentBaitingDAO.rodentBaitingWithRatsPremisesBaitedLessThan(number);
	}

}
