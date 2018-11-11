package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.tarena.dao.IOrderDao;
import com.tarena.entity.Order;
import com.tarena.util.datasource.DBConnection;

public class OrderDaoImpl implements IOrderDao {

	public int addOrder(Order order) throws Exception {
		String sql = "insert into d_order(status,order_time,total_price,"
				+ "receive_name,full_address,postal_code,mobile,phone,user_id) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		conn = DBConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stat.setInt(1, order.getStatus());
		stat.setLong(2, order.getOrderTime());
		stat.setDouble(3, order.getTotalPrice());
		stat.setString(4, order.getReceiveName());
		stat.setString(5, order.getFullAddress());
		stat.setString(6, order.getPostalCode());
		stat.setString(7, order.getMobile());
		stat.setString(8, order.getPhone());
		stat.setInt(9, order.getUserId());
		stat.executeUpdate();
		ResultSet rs = stat.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		return id;
	}


	public void addReceive(Order order) throws Exception {
		String sql = "insert into d_receive_address("
				+ "receive_name,full_address,postal_code,mobile,phone,user_id) "
				+ "values(?,?,?,?,?,?)";
		Connection conn = null;
		conn = DBConnection.getConnection();
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, order.getReceiveName());
		stat.setString(2, order.getFullAddress());
		stat.setString(3, order.getPostalCode());
		stat.setString(4, order.getMobile());
		stat.setString(5, order.getPhone());
		stat.setInt(6, order.getUserId());
		stat.executeUpdate();
	}

	public List<Order> findByUserId(int userId) throws Exception {
		String sql = "select*from d_receive_address where user_id=? ";
		PreparedStatement stat = DBConnection.getConnection().prepareStatement(sql);
		stat.setInt(1, userId);
		ResultSet rs = stat.executeQuery();
		List<Order> orders = new ArrayList<Order>();
		while (rs.next()) {
			Order order = new Order();
			order.setReceiveName(rs.getString("receive_name"));
			order.setId(rs.getInt("id"));
			orders.add(order);
		}
		return orders;
	}

	public Order findById(int id) throws Exception {
		String sql = "select*from d_receive_address where id=? ";
		PreparedStatement stat = DBConnection.getConnection().prepareStatement(sql);
		stat.setInt(1, id);
		ResultSet rs = stat.executeQuery();
		Order order = new Order();
		while (rs.next()) {
			order.setReceiveName(rs.getString("receive_name"));
			order.setFullAddress(rs.getString("full_address"));
			order.setPostalCode(rs.getString("postal_code"));
			order.setPhone(rs.getString("phone"));
			order.setMobile(rs.getString("mobile"));
		}
		return order;
	}

}
