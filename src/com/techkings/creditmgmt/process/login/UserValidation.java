package com.techkings.creditmgmt.process.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.techkings.creditmgmt.dbevents.DbAccess;

public class UserValidation {

	private String userId = null;
	private String password = null;
	private String firstName = null;
	private String lastName = null;
	private UserDetailBean userDetailBean = new UserDetailBean();

	public UserValidation(String userName, String password) {
		userId = userName;
		this.password = password;
	}

	public UserValidation(String userName, String password, String firstName,
			String lastName) {
		this(userName, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public boolean isValidUser() {
		DbAccess dbAccess = DbAccess.getInstance();
		boolean isValidUser = false;
		String selectUserQuery = "select * from UserDetail where User_id = '"
				+ userId + "' and Password = '" + password + "'";
		ResultSet rs = dbAccess.executeQuery(selectUserQuery);
		try {
			if (null != rs && rs.next()) {
				userDetailBean.setUserDetailPk(rs.getLong("User_Detail_pk"));
				userDetailBean.setFirstName(rs.getString("First_Name"));
				userDetailBean.setLastName(rs.getString("Last_Name"));
				isValidUser = true;
			} else {
				System.out.println("Invalid user.");
			}
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception occurred. ");
		} finally {
			dbAccess.closeResultSet(rs);
		}
		return isValidUser;
	}

	public boolean isUserAvailable() {
		DbAccess dbAccess = DbAccess.getInstance();
		boolean isUserAvailable = false;
		String selectUserQuery = "select * from UserDetail where User_id = '"
				+ userId + "'";
		ResultSet rs = dbAccess.executeQuery(selectUserQuery);
		try {
			if (null != rs && rs.next()) {
				isUserAvailable = true;
			}
		} catch (SQLException sqlException) {
			System.out.println("SQL Exception occurred. ");
		} finally {
			dbAccess.closeResultSet(rs);
		}
		return isUserAvailable;
	}

	public boolean createUser() {
		DbAccess dbAccess = DbAccess.getInstance();
		String insertUserQuery = "insert into UserDetail (User_Id, Password, First_Name, Last_Name) values ('"
				+ userId
				+ "','"
				+ password
				+ "','"
				+ firstName
				+ "','"
				+ lastName + "')";
		if (dbAccess.executeUpdate(insertUserQuery) < 0) {
			return false;
		} else {
			return true;
		}

	}

	public UserDetailBean getUserDetail() {
		return userDetailBean;
	}

	public void resetUserDetail() {
		userDetailBean = new UserDetailBean();
	}

}
