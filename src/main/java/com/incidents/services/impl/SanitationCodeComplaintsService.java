package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.SanitationCodeComplaints;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.IncidentDAO;
import com.incidents.repositories.SanitationCodeComplaintsDAO;

@Service("SanitationCodeComplaints")
public class SanitationCodeComplaintsService {

	@Autowired
	IncidentDAO incidentDao;
	
	@Autowired
	SanitationCodeComplaintsDAO dao;
	
	@Transactional
	public SanitationCodeComplaints create(String status, String streetAddress, Integer xCoordinate,
			Integer yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea, Integer latitude, Integer longitude,
			String location, String natureOfViolation) {
		Incident newIncident = new Incident();
		newIncident.setCreatedAt(new Date());
		newIncident.setType(TypeOfServiceRequest.SANITATION_CODE_COMPLAINTS);
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
		
		SanitationCodeComplaints newSanitationCodeComplaints = new SanitationCodeComplaints();
		newSanitationCodeComplaints.setIncident(newIncident);
		newSanitationCodeComplaints.setNatureOfViolation(natureOfViolation);
		
		dao.save(newSanitationCodeComplaints);
		return newSanitationCodeComplaints;
	}
	
}
