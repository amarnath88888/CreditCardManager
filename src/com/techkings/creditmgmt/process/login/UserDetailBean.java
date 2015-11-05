package com.techkings.creditmgmt.process.login;

public class UserDetailBean {
	private String userName = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private Long userDetailPk = null;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Long getUserDetailPk() {
		return userDetailPk;
	}

	public void setUserDetailPk(Long userDetailPk) {
		this.userDetailPk = userDetailPk;
	}
}
