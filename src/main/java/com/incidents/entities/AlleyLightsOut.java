package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ALLEY_LIGHTS_OUT")
public class AlleyLightsOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	public AlleyLightsOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlleyLightsOut(Integer id, Incident incident) {
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
		return "AlleyLightsOut [id=" + id + ", incident=" + incident + "]";
	}

}
