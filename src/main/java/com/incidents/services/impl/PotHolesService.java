package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.PotHoles;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.repositories.PotHolesDAO;

@Service("PotHoles")
public class PotHolesService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	PotHolesDAO dao;
	
	@Transactional
	public PotHoles create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location, String currentActivity, String mostRecentAction, Integer potHoles,
			String ssa) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.POT_HOLES_REPORTED);
		newIncident.setStatus(status);
		newIncident.setStreetAddress(streetAddress);
		newIncident.setZipCode(zipCode);
		newIncident.setxCoordinate(xCoordinate);
		newIncident.setyCoordinate(yCoordinate);
		newIncident.setWard(ward);
		newIncident.setPoliceDistrict(policeDistrict);
		newIncident.setCommunityArea(communityArea);
		newIncident.setLatitude(latitude);
		newIncident.setLongitude(longitude);
		newIncident.setLocation(location);
		incidentDao.save(newIncident);
		
		PotHoles newPotHoles = new PotHoles();
		newPotHoles.setIncident(newIncident);
		newPotHoles.setCurrentActivity(currentActivity);
		newPotHoles.setMostRecentAction(mostRecentAction);
		newPotHoles.setPotHoles(potHoles);
		newPotHoles.setSsa(ssa);
		
		dao.save(newPotHoles);
		return newPotHoles;
	}
	
}
