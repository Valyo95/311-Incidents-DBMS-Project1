package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.AbandonedVehicles;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;

@Service("AbandonedVehicles")
public class AbandonedVehiclesService {

	@Autowired
	AbandonedVehiclesDAO dao;
	
	@Transactional
	public AbandonedVehicles create(String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.ABANDONED_VEHICLES);
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
		
		AbandonedVehicles newAbandonedVehicle = new AbandonedVehicles();
		newAbandonedVehicle.setIncident(newIncident);
		
		dao.save(newAbandonedVehicle);
		return newAbandonedVehicle;
	}
	
}
