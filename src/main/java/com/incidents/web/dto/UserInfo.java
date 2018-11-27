package com.incidents.web.dto;


public class UserInfo {

	
	private long id;
	private String username;
	private String email;	
	private String firstName;
	private String lastName;
	private String phone;
	private String imagePath;
	private Long connected;
	private String position;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Long getConnected() {
		return connected;
	}
	public void setConnected(Long connected) {
		this.connected = connected;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", imagePath=" + imagePath + ", connected="
				+ connected + ", position=" + position + "]";
	}
	public UserInfo(long id, String username, String email, String firstName, String lastName, String phone,
			String imagePath, Long connected, String position) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.imagePath = imagePath;
		this.connected = connected;
		this.position = position;
	}
	
	public UserInfo() {;}
}
