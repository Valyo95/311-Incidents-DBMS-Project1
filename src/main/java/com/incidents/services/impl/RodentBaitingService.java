package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.RodentBaiting;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.repositories.RodentBaitingDAO;
import com.tc.util.UUID;

@Service("RodentBaiting")
public class RodentBaitingService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	RodentBaitingDAO dao;
	
	@Transactional
	public RodentBaiting create(String status, String streetAddress, String zipCode, Double xCoordinate,
			Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Double latitude, Double longitude,
			String location, Double premisesBaited, Double premisesWithGarbage, Double premisesWithRats, String currentActivity, String mostRecentAction) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.RODENT_BAITING);
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
		
		RodentBaiting newRodentBaiting = new RodentBaiting();
		newRodentBaiting.setIncident(newIncident);
		newRodentBaiting.setPremisesBaited(premisesBaited);
		newRodentBaiting.setPremisesWithGarbage(premisesWithGarbage);
		newRodentBaiting.setPremisesWithRats(premisesWithRats);
		newRodentBaiting.setCurrentActivity(currentActivity);
		newRodentBaiting.setMostRecentAction(mostRecentAction);
		
		dao.save(newRodentBaiting);
		return newRodentBaiting;
	}
	
}
