package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.TreeDebris;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.repositories.TreeDebrisDAO;
import com.tc.util.UUID;

@Service("TreeDebris")
public class TreeDebrisService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	TreeDebrisDAO dao;
	
	@Transactional
	public TreeDebris create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location, String location2, String currentActivity, String mostRecentAction) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.TREE_DEBRIS);
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
		
		TreeDebris newTreeDebris = new TreeDebris();
		newTreeDebris.setIncident(newIncident);
		newTreeDebris.setLocation(location2);
		newTreeDebris.setCurrentActivity(currentActivity);
		newTreeDebris.setMostRecentAction(mostRecentAction);
		
		dao.save(newTreeDebris);
		return newTreeDebris;
	}
	
}
