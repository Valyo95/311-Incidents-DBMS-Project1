package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.incidents.enumerations.TypeOfServiceRequest;

@Entity
@Table(name = "INCIDENT")
public class Incident implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
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
	private Integer xCoordinate;

	@Column(name = "Y_COORDINATE")
	private Integer yCoordinate;

	@Column(name = "WARD")
	private Integer ward;

	@Column(name = "POLICE_DISTRICT")
	private Integer policeDistrict;

	@Column(name = "COMMUNITY_AREA")
	private Integer communityArea;

	@Column(name = "LATITUDE")
	private Integer latitude;

	@Column(name = "LONGITUDE")
	private Integer longitude;

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
			Integer xCoordinate, Integer yCoordinate, Integer ward, Integer policeDistrict, Integer communityArea,
			Integer latitude, Integer longitude, String location, Date createdAt, Date completionDate) {
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

	public Integer getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Integer xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Integer getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Integer yCoordinate) {
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

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
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
