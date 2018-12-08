package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.incidents.enumerations.TypeOfServiceRequest;

@Entity
@Table(name = "INCIDENT")
public class Incident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "srn", length = 200)
	private String srn;

	@Column(name = "STATUS", length = 200)
	private String status;

	@Column(name = "SERVICE_REQUEST_TYPE", length = 200)
	private TypeOfServiceRequest type;

	@Column(name = "STREET_ADDRESS", length = 200)
	private String streetAddress;

	@Column(name = "X_COORDINATE")
	private int xCoordinate;

	@Column(name = "Y_COORDINATE")
	private int yCoordinate;

	@Column(name = "WARD")
	private int ward;

	@Column(name = "POLICE_DISTRICT")
	private int policeDistrict;

	@Column(name = "COMMUNITY_AREA")
	private int communityArea;

	@Column(name = "LATITUDE")
	private int latitude;

	@Column(name = "LONGITUDE")
	private int longitude;

	@Column(name = "LOCATION", length = 200)
	private String location;

	@Column(name = "CREATION_DATE", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(name = "COMPLETION_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date completionDate;

	public Incident() {
		super();
	}

	public Incident(String srn, String status, TypeOfServiceRequest type, String streetAddress, int xCoordinate,
			int yCoordinate, int ward, int policeDistrict, int communityArea, int latitude, int longitude,
			String location, Date createdAt, Date completionDate) {
		super();
		this.srn = srn;
		this.status = status;
		this.type = type;
		this.streetAddress = streetAddress;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.ward = ward;
		this.policeDistrict = policeDistrict;
		this.communityArea = communityArea;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location = location;
		this.createdAt = createdAt;
		this.completionDate = completionDate;
	}

	public String getSrn() {
		return srn;
	}

	public void setSrn(String srn) {
		this.srn = srn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TypeOfServiceRequest getType() {
		return type;
	}

	public void setType(TypeOfServiceRequest type) {
		this.type = type;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getWard() {
		return ward;
	}

	public void setWard(int ward) {
		this.ward = ward;
	}

	public int getPoliceDistrict() {
		return policeDistrict;
	}

	public void setPoliceDistrict(int policeDistrict) {
		this.policeDistrict = policeDistrict;
	}

	public int getCommunityArea() {
		return communityArea;
	}

	public void setCommunityArea(int communityArea) {
		this.communityArea = communityArea;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Complaint [srn=" + srn + ", status=" + status + ", type=" + type + ", streetAddress=" + streetAddress
				+ ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", ward=" + ward
				+ ", policeDistrict=" + policeDistrict + ", communityArea=" + communityArea + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", location=" + location + ", createdAt=" + createdAt
				+ ", completionDate=" + completionDate + "]";
	}

}
