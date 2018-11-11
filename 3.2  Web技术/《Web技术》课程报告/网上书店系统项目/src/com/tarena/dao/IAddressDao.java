package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Address;

public interface IAddressDao {
	
	public void addAddress(Address address) throws Exception;
	
	public List<Address> findAddressByUserId(int userId) throws Exception;
}
