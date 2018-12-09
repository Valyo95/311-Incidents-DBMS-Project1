package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.LightsAllOut;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.repositories.LightsAllOutDAO;

@Service("LightsAllOut")
public class LightsAllOutService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	LightsAllOutDAO dao;
	
	@Transactional
	public LightsAllOut create(String status, String streetAddress, Integer xCoordinate,
			Integer yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Integer latitude, Integer longitude,
			String location) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.LIGHTS_ALL_OUT);
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
		incidentDao.save(newIncident);
		
		LightsAllOut newLightsAllOut = new LightsAllOut();
		newLightsAllOut.setIncident(newIncident);
		
		dao.save(newLightsAllOut);
		return newLightsAllOut;
	}
	
}
