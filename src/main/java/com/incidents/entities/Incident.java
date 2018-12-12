package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.incidents.enumerations.TypeOfServiceRequest;

@Entity
@Table(name = "INCIDENT")
public class Incident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "srn", length = 200)
	private String srn;

	@Column(name = "STATUS", length = 200)
	private String status;

	@Enumerated(EnumType.STRING)
	@Column(name = "SERVICE_REQUEST_TYPE")
	private TypeOfServiceRequest type;

	@Column(name = "STREET_ADDRESS", length = 200)
	private String streetAddress;

	@Column(name = "ZIP_CODE", length = 200)
	private String zipCode;

	@Column(name = "X_COORDINATE")
	private Double xCoordinate;

	@Column(name = "Y_COORDINATE")
	private Double yCoordinate;

	@Column(name = "WARD")
	private Integer ward;

	@Column(name = "POLICE_DISTRICT")
	private Integer policeDistrict;

	@Column(name = "COMMUNITY_AREA")
	private Integer communityArea;

	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "LOCATION", length = 200)
	private String location;

	@Column(name = "CREATION_DATE", nullable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "COMPLETION_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date completionDate;

	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Incident(String srn, String status, TypeOfServiceRequest type, String streetAddress, String zipCode,
			Double xCoordinate, Double yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea,
			Double latitude, Double longitude, String location, Date createdAt, Date completionDate) {
		super();
		this.srn = srn;
		this.status = status;
		this.type = type;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Integer getWard() {
		return ward;
	}

	public void setWard(Integer ward) {
		this.ward = ward;
	}

	public Integer getPoliceDistrict() {
		return policeDistrict;
	}

	public void setPoliceDistrict(Integer policeDistrict) {
		this.policeDistrict = policeDistrict;
	}

	public Integer getCommunityArea() {
		return communityArea;
	}

	public void setCommunityArea(Integer communityArea) {
		this.communityArea = communityArea;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
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
		return "Incident [srn=" + srn + ", status=" + status + ", type=" + type + ", streetAddress=" + streetAddress
				+ ", zipCode=" + zipCode + ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + ", ward="
				+ ward + ", policeDistrict=" + policeDistrict + ", communityArea=" + communityArea + ", latitude="
				+ latitude + ", longitude=" + longitude + ", location=" + location + ", createdAt=" + createdAt
				+ ", completionDate=" + completionDate + "]";
	}
}
