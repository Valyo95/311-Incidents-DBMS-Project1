package com.incidents.web;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.AbandonedVehicles;
import com.incidents.entities.Audit;
import com.incidents.entities.MyUser;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.services.Users;
import com.incidents.services.impl.AbandonedVehiclesService;
import com.incidents.services.impl.AuditService;
import com.incidents.util.Util;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class AbandonedVehiclesEndpoint {

	@Autowired
	private IncidentDAO inDao;

	@Autowired
	private Users userService;

	@Autowired
	private AuditService auditService;

	@Autowired
	private AbandonedVehiclesDAO abandonedVehiclesDAO;

	@Autowired
	private AbandonedVehiclesService service;

	@RequestMapping(value = "/abandonedVehiclesEndpoint/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public AbandonedVehicles create(Principal principal, @RequestParam("status") String status,
			@RequestParam("streetAddress") String streetAddress, @RequestParam("zipCode") String zipCode,
			@RequestParam("xCoordinate") Double xCoordinate, @RequestParam("yCoordinate") Double yCoordinate,
			@RequestParam("ward") Integer ward, @RequestParam("policeDistrict") Integer policeDistrict,
			@RequestParam("communityArea") Integer communityArea, @RequestParam("latitude") Double latitude,
			@RequestParam("longitude") Double longitude, @RequestParam("location") String location,
			@RequestParam("licensePlate") String licensePlate, @RequestParam("model") String model,
			@RequestParam("color") String color, @RequestParam("currentActivity") String currentActivity,
			@RequestParam("mostRecentAction") String mostRecentAction,
			@RequestParam("daysAbandoned") Double daysAbandoned, @RequestParam("ssa") String ssa) {
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
				communityArea, latitude, longitude, location, licensePlate, model, color, currentActivity,
				mostRecentAction, daysAbandoned, ssa);
	}

	@RequestMapping(value = "/moreThanOnceAbandoned", method = RequestMethod.GET)
	public List<Object> moreThanOnceAbandoned(Principal principal) throws ParseException {		
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

		auditService.create(user, Util.getMethodName(), "");
		return abandonedVehiclesDAO.moreThanOnceAbandoned();
	}

	@RequestMapping(value = "/secondCommonColor", method = RequestMethod.GET)
	public List<Object> secondCommonColor(Principal principal) throws ParseException {
		MyUser user;
		if (principal != null) {
			try {
				user=userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}
		
		auditService.create(user, Util.getMethodName(), "");
		return abandonedVehiclesDAO.secondCommonColor();
	}
}
