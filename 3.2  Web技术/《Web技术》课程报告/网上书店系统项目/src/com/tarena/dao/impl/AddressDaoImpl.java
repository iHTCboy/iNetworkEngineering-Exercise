package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.IAddressDao;
import com.tarena.entity.Address;
import com.tarena.util.datasource.DBConnection;

public class AddressDaoImpl implements IAddressDao{

	public void addAddress(Address address) throws Exception {
		Connection conn = null;
		PreparedStatement stat = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "insert into d_receive_address(user_id,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?);";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, address.getUserId());
			stat.setString(2, address.getReceiveName());
			stat.setString(3, address.getFullAddress());
			stat.setString(4, address.getPostalCode());
			stat.setString(5, address.getMobile());
			stat.setString(6, address.getPhone());
			stat.executeUpdate();
		}finally{
			DBConnection.close(stat, conn);
		}
	}

	public List<Address> findAddressByUserId(int userId) throws Exception {
		List<Address> addresses = new ArrayList<Address>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "select * from d_receive_address where user_id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, userId);
			rs = stat.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String receiveName = rs.getString("receive_name");
				String fullAddress = rs.getString("full_address");
				String postalCode = rs.getString("postal_code");
				String mobile = rs.getString("mobile");
				String phone = rs.getString("phone");
				
				Address address = new Address();
				address.setId(id);
				address.setUserId(userId);
				address.setReceiveName(receiveName);
				address.setFullAddress(fullAddress);
				address.setPostalCode(postalCode);
				address.setMobile(mobile);
				address.setPhone(phone);
				
				addresses.add(address);
			}
		}finally{
			DBConnection.close(rs, stat, conn);
		}
		
		return addresses;
	}
}
