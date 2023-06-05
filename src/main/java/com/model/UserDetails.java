package com.model;

public class UserDetails {
	private int id;

	// user details 
	private String firstName;
	private String lastName;
	private String fullName;
	private String address;
	private String contact;
	private String gender;
	private int stateId;
	private int cityId;
	private String email;
	private String dob;
	private String regDate;
	private String lastModified;
	private int isAdmin;
	
	// user creds
	private String userId;
	private String password;
	
	public UserDetails() {}
	
	public UserDetails(int id, String firstName, String lastName, String address, String contact,
			String gender, int stateId, int cityId, String email, String dob,
			int isAdmin) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.gender = gender;
		this.stateId = stateId;
		this.cityId = cityId;
		this.email = email;
		this.dob = dob;
		this.isAdmin = isAdmin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", address=" + address + ", contact=" + contact + ", gender=" + gender + ", stateId="
				+ stateId + ", cityId=" + cityId + ", email=" + email + ", dob=" + dob + ", regDate=" + regDate
				+ ", lastModified=" + lastModified + ", isAdmin=" + isAdmin + ", userId=" + userId + ", password="
				+ password + ", getUserId()=" + getUserId() + ", getPassword()=" + getPassword() + ", getId()="
				+ getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getFullName()=" + getFullName() + ", getAddress()=" + getAddress() + ", getContact()="
				+ getContact() + ", getGender()=" + getGender() + ", getStateId()=" + getStateId() + ", getCityId()="
				+ getCityId() + ", getEmail()=" + getEmail() + ", getDob()=" + getDob() + ", getRegDate()="
				+ getRegDate() + ", getLastModified()=" + getLastModified() + ", getIsAdmin()=" + getIsAdmin()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
