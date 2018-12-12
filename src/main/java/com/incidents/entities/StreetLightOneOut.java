package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "LIGHTS_ONE_OUT")
public class StreetLightOneOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "incident_id", referencedColumnName = "id")
	private Incident incident;

	public StreetLightOneOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StreetLightOneOut(Integer id, Incident incident) {
		super();
		this.id = id;
		this.incident = incident;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StreetLightOneOut [id=" + id + ", incident=" + incident + "]";
	}

}
