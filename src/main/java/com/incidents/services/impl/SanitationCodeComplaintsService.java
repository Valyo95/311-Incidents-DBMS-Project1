package com.incidents.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incidents.entities.Incident;
import com.incidents.entities.SanitationCodeComplaints;
import com.incidents.enumerations.TypeOfServiceRequest;
import com.incidents.repositories.AbandonedVehiclesDAO;
import com.incidents.repositories.SanitationCodeComplaintsDAO;

@Service("SanitationCodeComplaints")
public class SanitationCodeComplaintsService {

	@Autowired
	SanitationCodeComplaintsDAO dao;
	
	@Transactional
	public SanitationCodeComplaints create(String srn, String status, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, Date createdAt, Date completionDate) {
		Incident newIncident = new Incident();
		newIncident.setType(TypeOfServiceRequest.SANITATION_CODE_COMPLAINTS);
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
		
		SanitationCodeComplaints newSanitationCodeComplaints = new SanitationCodeComplaints();
		newSanitationCodeComplaints.setIncident(newIncident);
		
		dao.save(newSanitationCodeComplaints);
		return newSanitationCodeComplaints;
	}
	
}
