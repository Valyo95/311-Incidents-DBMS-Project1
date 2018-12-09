package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.TreeDebris;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.TreeDebrisDAO;

@Service("TreeDebris")
public class TreeDebrisService {

	@Autowired
	TreeDebrisDAO dao;
	
	@Transactional
	public TreeDebris create(String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.TREE_DEBRIS);
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
		
		TreeDebris newTreeDebris = new TreeDebris();
		newTreeDebris.setIncident(newIncident);
		
		dao.save(newTreeDebris);
		return newTreeDebris;
	}
	
}
