package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ABANDONED_VEHICLES", indexes = {
		@Index(name = "SSA_INDEX", columnList = "SSA", unique = false) })
public class AbandonedVehicles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	@Column(name = "LICENSE_PLATE", length = 400)
	private String licensePlate;

	@Column(name = "MODEL", length = 200)
	private String model;

	@Column(name = "COLOR")
	private String color;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	@Column(name = "DAYS_ABANDONED")
	private Double daysAbandoned;

	@Column(name = "SSA", length = 200)
	private String ssa;

	public AbandonedVehicles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbandonedVehicles(Incident incident, String licensePlate, String model, String color,
			String currentActivity, String mostRecentAction, Double daysAbandoned, String ssa) {
		super();
		this.incident = incident;
		this.licensePlate = licensePlate;
		this.model = model;
		this.color = color;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
		this.daysAbandoned = daysAbandoned;
		this.ssa = ssa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(String currentActivity) {
		this.currentActivity = currentActivity;
	}

	public String getMostRecentAction() {
		return mostRecentAction;
	}

	public void setMostRecentAction(String mostRecentAction) {
		this.mostRecentAction = mostRecentAction;
	}

	public Double getDaysAbandoned() {
		return daysAbandoned;
	}

	public void setDaysAbandoned(Double daysAbandoned) {
		this.daysAbandoned = daysAbandoned;
	}

	public String getSsa() {
		return ssa;
	}

	public void setSsa(String ssa) {
		this.ssa = ssa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AbandonedVehicles [id=" + id + ", incident=" + incident + ", licensePlate=" + licensePlate
				+ ", model=" + model + ", color=" + color + ", currentActivity=" + currentActivity
				+ ", mostRecentAction=" + mostRecentAction + ", daysAbandoned=" + daysAbandoned + ", ssa=" + ssa + "]";
	}

}
