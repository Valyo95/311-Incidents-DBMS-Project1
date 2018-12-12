package com.incidents.web;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.incidents.entities.AbandonedVehicles;
import com.incidents.entities.MyUser;
import com.incidents.entities.TreeTrims;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.exceptions.EntityNotFoundException;
import com.incidents.repositories.IncidentDAO;
import com.incidents.services.Users;
import com.incidents.services.impl.AbandonedVehiclesService;
import com.incidents.services.impl.TreeTrimsService;

@RestController
public class IncidentEndpoint {

	@Autowired
	private IncidentDAO inDao;

	@Autowired
	private Users userService;

	@RequestMapping(value = "/getTotalRequestsPerType", method = RequestMethod.GET)
	public List<Object> getTotalRequestsPerType(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return inDao.getTotalRequestsPerType(fromDate, toDate);
	}

	@RequestMapping(value = "/getTotalRequestsPerDayAndType", method = RequestMethod.GET)
	public List<Object> getTotalRequestsPerDayAndType(Principal principal,
			@RequestParam("type") TypeOfServiceRequest typeOfServiceRequest,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return inDao.getTotalRequestsPerDayAndType(typeOfServiceRequest, fromDate, toDate);
	}
	
	@RequestMapping(value = "/mostCommonServicePerZipCode", method = RequestMethod.GET)
	public List<Object> mostCommonServicePerZipCode(Principal principal,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return inDao.mostCommonServicePerZipCode(date);
	}
	
	@RequestMapping(value = "/avgCompletionTime", method = RequestMethod.GET)
	public List<Object> avgCompletionTime(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return inDao.avgCompletionTime(fromDate, toDate);
	}
	
	@RequestMapping(value = "/topFiveSSA", method = RequestMethod.GET)
	public List<Object> topFiveSSA(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {

		if (principal != null) {
			try {
				userService.findByUsername(principal.getName());
			} catch (EntityNotFoundException e) {
				return null;
			}
		} else {
			return null;
		}

		return inDao.topFiveSSA(fromDate, toDate);
	}
}
