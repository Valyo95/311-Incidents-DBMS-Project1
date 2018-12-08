package com.incidents.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TREE_TRIMS")
public class TreeTrims implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Incident incident;

	@Column(name = "LOCATION", length = 200)
	private String location;

	public TreeTrims() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TreeTrims(int id, Incident incident, String location) {
		super();
		this.id = id;
		this.incident = incident;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TreeTrims [id=" + id + ", incident=" + incident + ", location=" + location + "]";
	}

}
