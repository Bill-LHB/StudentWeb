package com.lhb.studentmanager.model;

/**
 * 用户bean类
 * 
 * @author Administrator
 *
 */
public class User {
	private int id;// ID
	private String userName;// 用户名
	private String password;// 密码
	private int rank;// 权限

	public User() {

	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public User(String userName, String password, int rank, int id) {

		this.userName = userName;
		this.password = password;
		this.rank = rank;
		this.id = id;
	}

	public User(String userName, String password, int rank) {

		this.userName = userName;
		this.password = password;
		this.rank = rank;
	}

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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	}

}
