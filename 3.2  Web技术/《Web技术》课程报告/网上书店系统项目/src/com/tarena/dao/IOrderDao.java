package com.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import com.tarena.entity.Order;

public interface IOrderDao {
	public int addOrder(Order order)throws SQLException, Exception;
	public void addReceive(Order order)throws SQLException, Exception;
	public List<Order> findByUserId(int userId)throws SQLException, Exception;
	public Order findById(int id)throws SQLException, Exception;
}
