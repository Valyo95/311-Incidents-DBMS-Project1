package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TREE_DEBRIS")
public class TreeDebris implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	@Column(name = "LOCATION", length = 200)
	private String location;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	public TreeDebris() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeDebris(int id, Incident incident, String location, String currentActivity, String mostRecentAction) {
		super();
		this.id = id;
		this.incident = incident;
		this.location = location;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TreeDebris [id=" + id + ", incident=" + incident + ", location=" + location + ", currentActivity="
				+ currentActivity + ", mostRecentAction=" + mostRecentAction + "]";
	}

}
