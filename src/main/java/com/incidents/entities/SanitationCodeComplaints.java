package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "SANITATION_CODE_COMPLAINTS")
public class SanitationCodeComplaints implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	@Column(name = "NATURE_OF_VIOLATION", length = 200)
	private String natureOfViolation;

	public SanitationCodeComplaints() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanitationCodeComplaints(int id, Incident incident, String natureOfViolation) {
		super();
		this.id = id;
		this.incident = incident;
		this.natureOfViolation = natureOfViolation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Incident getComplaint() {
		return incident;
	}

	public void setComplaint(Incident incident) {
		this.incident = incident;
	}

	public String getNatureOfViolation() {
		return natureOfViolation;
	}

	public void setNatureOfViolation(String natureOfViolation) {
		this.natureOfViolation = natureOfViolation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SanitationCodeComplaints [id=" + id + ", incident=" + incident + ", natureOfViolation="
				+ natureOfViolation + "]";
	}

}
