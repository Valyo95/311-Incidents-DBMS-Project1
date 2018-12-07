package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ForeignKey;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.easynotes.enumerations.TypeOfServiceRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "SANITATION_CODE_COMPLAINTS")
public class SanitationCodeComplaints implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "srn", referencedColumnName = "srn")
	private Complaint complaint;

	@Column(name = "NATURE_OF_VIOLATION", length = 200)
	private String natureOfViolation;

	public SanitationCodeComplaints() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanitationCodeComplaints(int id, Complaint complaint, String natureOfViolation) {
		super();
		this.id = id;
		this.complaint = complaint;
		this.natureOfViolation = natureOfViolation;
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
		return "SanitationCodeComplaints [id=" + id + ", complaint=" + complaint + ", natureOfViolation="
				+ natureOfViolation + "]";
	}

}
