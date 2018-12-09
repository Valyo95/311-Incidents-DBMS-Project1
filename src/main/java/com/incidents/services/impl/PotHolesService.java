package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.PotHoles;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.PotHolesDAO;

@Service("PotHoles")
public class PotHolesService {

	@Autowired
	PotHolesDAO dao;
	
	@Transactional
	public PotHoles create(String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, String currentActivity, String mostRecentAction, int potHoles,
			String ssa) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.POT_HOLES_REPORTED);
		newIncident.setStatus(status);
		newIncident.setStreetAddress(streetAddress);
		newIncident.setxCoordinate(xCoordinate);
		newIncident.setyCoordinate(yCoordinate);
		newIncident.setWard(ward);
		newIncident.setPoliceDistrict(policeDistrict);
		newIncident.setCommunityArea(communityArea);
		newIncident.setLatitude(latitude);
		newIncident.setLongitude(longitude);
		newIncident.setLocation(location);
		
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
