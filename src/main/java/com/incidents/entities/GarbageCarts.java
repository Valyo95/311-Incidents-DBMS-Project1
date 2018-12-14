package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "GARBAGE_CARTS", indexes = { @Index(name = "SSA_INDEX", columnList = "SSA", unique = false) })
public class GarbageCarts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	@Column(name = "BLACK_CARTS_DELIEVRED")
	private Long blackCartsDelivered;

	@Column(name = "CURRENT_ACTIVITY", length = 200)
	private String currentActivity;

	@Column(name = "MOST_RECENT_ACTION", length = 200)
	private String mostRecentAction;

	@Column(name = "SSA", length = 200)
	private String ssa;

	public GarbageCarts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GarbageCarts(final Integer id, final Incident incident, final Long blackCartsDelivered,
			final String currentActivity, final String mostRecentAction, final String ssa) {
		super();
		this.id = id;
		this.incident = incident;
		this.blackCartsDelivered = blackCartsDelivered;
		this.currentActivity = currentActivity;
		this.mostRecentAction = mostRecentAction;
		this.ssa = ssa;
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

	public Long getBlackCartsDelivered() {
		return blackCartsDelivered;
	}

	public void setBlackCartsDelivered(final Long blackCartsDelivered) {
		this.blackCartsDelivered = blackCartsDelivered;
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

	public String getSsa() {
		return ssa;
	}

	public void setSsa(final String ssa) {
		this.ssa = ssa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GarbageCarts [id=" + id + ", incident=" + incident + ", blackCartsDelivered=" + blackCartsDelivered
				+ ", currentActivity=" + currentActivity + ", mostRecentAction=" + mostRecentAction + ", ssa=" + ssa
				+ "]";
	}
}
