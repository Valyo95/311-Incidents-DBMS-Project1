package com.incidents.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "AUDIT")
public class Audit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private MyUser user;

	@Column(name = "QUERY", length = 400)
	private String query;

	@Column(name = "PARAMS", length = 200)
	private String params;

	@Column(name = "CREATION_DATE", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Audit(Integer id, MyUser user, String query, String params, Date createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.query = query;
		this.params = params;
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Audit [id=" + id + ", user=" + user + ", query=" + query + ", params=" + params + ", createdAt="
				+ createdAt + "]";
	}

}
