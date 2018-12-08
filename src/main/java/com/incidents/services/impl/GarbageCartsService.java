package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.GarbageCarts;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.GarbageCartsDAO;

@Service("GarbageCarts")
public class GarbageCartsService {

	@Autowired
	GarbageCartsDAO dao;
	
	@Transactional
	public GarbageCarts create(String srn, String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, Date createdAt, Date completionDate) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.GARBAGE_CARTS);
		newIncident.setSrn(srn);
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
		newIncident.setCreatedAt(createdAt);
		newIncident.setCompletionDate(completionDate);
		
		GarbageCarts newGarbageCarts = new GarbageCarts();
		newGarbageCarts.setIncident(newIncident);
		
		dao.save(newGarbageCarts);
		return newGarbageCarts;
	}
	
}
