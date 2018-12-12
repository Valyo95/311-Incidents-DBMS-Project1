package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.AlleyLightsOut;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.AlleyLightsOutDAO;
import com.incidents.repositories.IncidentDAO;
import com.tc.util.UUID;

@Service("AlleyLightsOut")
public class AlleyLightsOutService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	AlleyLightsOutDAO dao;
	
	@Transactional
	public AlleyLightsOut create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.ALLEY_LIGHTS_OUT);
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
		
		AlleyLightsOut newAlleyLightsOut = new AlleyLightsOut();
		newAlleyLightsOut.setIncident(newIncident);
		
		dao.save(newAlleyLightsOut);
		return newAlleyLightsOut;
	}
	
}
