package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "GRAFFITI_REMOVAL", indexes = { @Index(name = "SSA_INDEX", columnList = "SSA", unique = false) })
public class GraffitiRemoval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	@Column(name = "TYPE_OF_SURFACE", length = 200)
	private String typeOfSurface;

	@Column(name = "LOCATED", length = 200)
	private String located;

	@Column(name = "SSA", length = 200)
	private String ssa;

	public GraffitiRemoval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GraffitiRemoval(Integer id, Incident incident, String typeOfSurface, String located, String ssa) {
		super();
		this.id = id;
		this.incident = incident;
		this.typeOfSurface = typeOfSurface;
		this.located = located;
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

	public String getTypeOfSurface() {
		return typeOfSurface;
	}

	public void setTypeOfSurface(String typeOfSurface) {
		this.typeOfSurface = typeOfSurface;
	}

	public String getLocated() {
		return located;
	}

	public void setLocated(String located) {
		this.located = located;
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
		return "GraffitiRemoval [id=" + id + ", incident=" + incident + ", typeOfSurface=" + typeOfSurface
				+ ", located=" + located + ", ssa=" + ssa + "]";
	}

}
