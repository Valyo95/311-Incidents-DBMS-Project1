package com.incidents.web.dto;

public class ChangePasswordInfo {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ChangePasswordInfo [status=" + status + "]";
	}
	
	
}
