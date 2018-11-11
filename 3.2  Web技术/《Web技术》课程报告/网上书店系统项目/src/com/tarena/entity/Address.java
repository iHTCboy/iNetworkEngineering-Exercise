package com.tarena.entity;

import java.io.Serializable;

public class Address implements Serializable {
	private int id;
	/**
	 * 用户
	 */
	private int userId;        
	/**
	 * 送货人
	 */
	private String receiveName;
	/**
	 * 送货地址
	 */
	private String fullAddress;
	/**
	 * 邮政编号
	 */
	private String postalCode;
	/**
	 * 用户手机号
	 */
	private String mobile;
	/**
	 * 用户电话
	 */
	private String phone;
	
	public Address() {
		
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
