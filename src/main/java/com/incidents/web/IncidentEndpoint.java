package com.incidents.web;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.incidents.services.impl.AuditService;
import com.incidents.services.impl.TreeTrimsService;
import com.incidents.util.Util;

@RestController
public class IncidentEndpoint {

	@Autowired
	private IncidentDAO inDao;

	@Autowired
	private Users userService;

	@Autowired
	private AuditService auditService;

	@RequestMapping(value = "/getTotalRequestsPerType", method = RequestMethod.GET)
	public List<Object> getTotalRequestsPerType(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {
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
		auditService.create(user, Util.getMethodName(), String.join(",", fromDate.toString(), toDate.toString()));

		return inDao.getTotalRequestsPerType(fromDate, toDate);
	}

	@RequestMapping(value = "/getTotalRequestsPerDayAndType", method = RequestMethod.GET)
	public List<Object> getTotalRequestsPerDayAndType(Principal principal,
			@RequestParam("start") int start,
			@RequestParam("size") int size,
			@RequestParam("type") TypeOfServiceRequest typeOfServiceRequest,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {
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
		auditService.create(user, Util.getMethodName(), String.join(",", typeOfServiceRequest.toString(),fromDate.toString(), toDate.toString()));

		List<Object> resultList = inDao.getTotalRequestsPerDayAndType(typeOfServiceRequest.name(), fromDate, toDate);
		
		//Paging handling
		int listSize = resultList.size();
		int end = start + size;
		
		if (start >= listSize) {
			return new ArrayList<Object>();
		}
		
		if (end > listSize) {
			end = listSize;
		}
		
		return resultList.subList(start, end);
	}
	
	@RequestMapping(value = "/mostCommonServicePerZipCode", method = RequestMethod.GET)
	public List<Object> mostCommonServicePerZipCode(Principal principal,
			@RequestParam("start") int start,
			@RequestParam("size") int size,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws ParseException {
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
		
		auditService.create(user, Util.getMethodName(), String.join(",", date.toString()));

		List<Object> resultList = inDao.mostCommonServicePerZipCode(date);
		
		//Paging handling
		int listSize = resultList.size();
		int end = start + size;
		
		if (start >= listSize) {
			return new ArrayList<Object>();
		}
		
		if (end > listSize) {
			end = listSize;
		}
		
		return resultList.subList(start, end);
	}
	
	@RequestMapping(value = "/avgCompletionTime", method = RequestMethod.GET)
	public List<Object> avgCompletionTime(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {
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

		auditService.create(user, Util.getMethodName(), String.join(",", fromDate.toString(),toDate.toString()));

		return inDao.avgCompletionTime(fromDate, toDate);
	}
	
	@RequestMapping(value = "/topFiveSSA", method = RequestMethod.GET)
	public List<Object> topFiveSSA(Principal principal,
			@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws ParseException {
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
		
		auditService.create(user, Util.getMethodName(), String.join(",", fromDate.toString(),toDate.toString()));
		
		return inDao.topFiveSSA(fromDate, toDate);
	}
}
