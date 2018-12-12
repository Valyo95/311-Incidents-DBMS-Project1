package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.AbandonedVehicles;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;

@Service("AbandonedVehicles")
public class AbandonedVehiclesService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	AbandonedVehiclesDAO dao;
	
	@Transactional
	public AbandonedVehicles create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location, String licensePlate, String model, String color, String currentActivity, String mostRecentAction, Double daysAbandoned, String ssa) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.ABANDONED_VEHICLES);
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
		
		AbandonedVehicles newAbandonedVehicle = new AbandonedVehicles();
		newAbandonedVehicle.setIncident(newIncident);
		newAbandonedVehicle.setLicensePlate(licensePlate);
		newAbandonedVehicle.setModel(model);
		newAbandonedVehicle.setColor(color);
		newAbandonedVehicle.setCurrentActivity(currentActivity);
		newAbandonedVehicle.setMostRecentAction(mostRecentAction);
		newAbandonedVehicle.setDaysAbandoned(daysAbandoned);
		newAbandonedVehicle.setSsa(ssa);
		
		dao.save(newAbandonedVehicle);
		return newAbandonedVehicle;
	}
	
}
