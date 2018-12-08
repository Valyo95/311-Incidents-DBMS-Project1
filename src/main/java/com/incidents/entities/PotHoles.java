package com.incidents.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "POT_HOLS")
public class PotHoles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	@Column(name = "POT_HOLS")
	private int potHoles;

	@Column(name = "SSA", length = 200)
	private String ssa;

	public PotHoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PotHoles(int id, Incident incident, String currentActivity, String mostRecentAction, int potHoles,
			String ssa) {
		super();
		this.id = id;
		this.incident = incident;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
		this.potHoles = potHoles;
		this.ssa = ssa;
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

	public int getPotHoles() {
		return potHoles;
	}

	public void setPotHoles(int potHoles) {
		this.potHoles = potHoles;
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
		return "PotHoles [id=" + id + ", incident=" + incident + ", currentActivity=" + currentActivity
				+ ", mostRecentAction=" + mostRecentAction + ", potHoles=" + potHoles + ", ssa=" + ssa + "]";
	}

}
