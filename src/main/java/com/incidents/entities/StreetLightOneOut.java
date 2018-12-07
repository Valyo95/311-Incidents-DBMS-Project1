package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "LIGHTS_ALL_OUT")
public class StreetLightOneOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Complaint complaint;

	public StreetLightOneOut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StreetLightOneOut(int id, Complaint complaint) {
		super();
		this.id = id;
		this.complaint = complaint;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StreetLightOneOut [id=" + id + ", complaint=" + complaint + "]";
	}

}
