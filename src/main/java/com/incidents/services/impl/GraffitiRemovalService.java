package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.GraffitiRemoval;
import com.incidents.entities.Incident;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.GraffitiRemovalDAO;

@Service("GraffitiRemoval")
public class GraffitiRemovalService {

	@Autowired
	GraffitiRemovalDAO dao;
	
	@Transactional
	public GraffitiRemoval create(String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, String typeOfSurface, String located, String ssa) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.GRAFFITI_REMOVAL);
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
		
		GraffitiRemoval newGraffitiRemoval = new GraffitiRemoval();
		newGraffitiRemoval.setIncident(newIncident);
		newGraffitiRemoval.setTypeOfSurface(typeOfSurface);
		newGraffitiRemoval.setLocated(located);
		newGraffitiRemoval.setSsa(ssa);
		
		dao.save(newGraffitiRemoval);
		return newGraffitiRemoval;
	}
	
}
