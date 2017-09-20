package com.xiaosuo.simple.bean;

/**
 * user实体
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
public class TUser {

	private int userId;
	private String userName;
	private String credits;
	private String password;
	private String lastVisit;
	private String lastIp;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the credits
	 */
	public String getCredits() {
		return credits;
	}
	/**
	 * @param credits the credits to set
	 */
	public void setCredits(String credits) {
		this.credits = credits;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the lastVisit
	 */
	public String getLastVisit() {
		return lastVisit;
	}
	/**
	 * @param lastVisit the lastVisit to set
	 */
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}
	/**
	 * @return the lastIp
	 */
	public String getLastIp() {
		return lastIp;
	}
	/**
	 * @param lastIp the lastIp to set
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
}
