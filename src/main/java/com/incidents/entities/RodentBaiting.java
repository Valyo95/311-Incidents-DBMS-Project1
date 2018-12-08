package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "RODENT_BAITING")
public class RodentBaiting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	@Column(name = "PREMISES_BAITED")
	private int premisesBaited;

	@Column(name = "PREMISES_WITH_GARBAGE")
	private int premisesWithGarbage;

	@Column(name = "PREMISES_WITH_RATS")
	private int premisesWithRats;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	public RodentBaiting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RodentBaiting(final int id, final Incident incident, final int premisesBaited,
			final int premisesWithGarbage, final int premisesWithRats, final String currentActivity,
			final String mostRecentAction) {
		super();
		this.id = id;
		this.incident = incident;
		this.premisesBaited = premisesBaited;
		this.premisesWithGarbage = premisesWithGarbage;
		this.premisesWithRats = premisesWithRats;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public Incident getComplaint() {
		return incident;
	}

	public void setComplaint(final Incident incident) {
		this.incident = incident;
	}

	public int getPremisesBaited() {
		return premisesBaited;
	}

	public void setPremisesBaited(final int premisesBaited) {
		this.premisesBaited = premisesBaited;
	}

	public int getPremisesWithGarbage() {
		return premisesWithGarbage;
	}

	public void setPremisesWithGarbage(final int premisesWithGarbage) {
		this.premisesWithGarbage = premisesWithGarbage;
	}

	public int getPremisesWithRats() {
		return premisesWithRats;
	}

	public void setPremisesWithRats(final int premisesWithRats) {
		this.premisesWithRats = premisesWithRats;
	}

	public String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(final String currentActivity) {
		this.currentActivity = currentActivity;
	}

	public String getMostRecentAction() {
		return mostRecentAction;
	}

	public void setMostRecentAction(final String mostRecentAction) {
		this.mostRecentAction = mostRecentAction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RodentBaiting [id=" + id + ", incident=" + incident + ", premisesBaited=" + premisesBaited
				+ ", premisesWithGarbage=" + premisesWithGarbage + ", premisesWithRats=" + premisesWithRats
				+ ", currentActivity=" + currentActivity + ", mostRecentAction=" + mostRecentAction + "]";
	}

}
