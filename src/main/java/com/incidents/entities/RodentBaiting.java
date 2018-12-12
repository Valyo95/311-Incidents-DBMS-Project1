package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "RODENT_BAITING")
public class RodentBaiting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Incident incident;

	@Column(name = "PREMISES_BAITED")
	private Double premisesBaited;

	@Column(name = "PREMISES_WITH_GARBAGE")
	private Double premisesWithGarbage;

	@Column(name = "PREMISES_WITH_RATS")
	private Double premisesWithRats;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	public RodentBaiting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RodentBaiting(final Integer id, final Incident incident, final Double premisesBaited,
			final Double premisesWithGarbage, final Double premisesWithRats, final String currentActivity,
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

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(final Incident incident) {
		this.incident = incident;
	}

	public Double getPremisesBaited() {
		return premisesBaited;
	}

	public void setPremisesBaited(final Double premisesBaited) {
		this.premisesBaited = premisesBaited;
	}

	public Double getPremisesWithGarbage() {
		return premisesWithGarbage;
	}

	public void setPremisesWithGarbage(final Double premisesWithGarbage) {
		this.premisesWithGarbage = premisesWithGarbage;
	}

	public Double getPremisesWithRats() {
		return premisesWithRats;
	}

	public void setPremisesWithRats(final Double premisesWithRats) {
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
