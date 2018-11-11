package com.tarena.entity;

public class User {
	/**
	 * id
	 */
	private int id;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 注册名
	 */
	private String nickname;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户等级
	 */
	private int userIntegral;
	/**
	 * 否email验证
	 */
	private boolean isEmailVerify;
	/**
	 * email验证码
	 */
	private String emailVerifyCode;
	/**
	 * 最后一次登录的时间
	 */
	private long lastLoginTime;
	/**
	 * 登录IP
	 */
	private String lastLoginIp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	public boolean isEmailVerify() {
		return isEmailVerify;
	}
	public void setEmailVerify(boolean isEmailVerify) {
		this.isEmailVerify = isEmailVerify;
	}
	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}
	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}
	public long getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
}
