package com.tarena.web.action.order;

import java.util.List;

import com.tarena.dao.IAddressDao;
import com.tarena.dao.IOrderDao;
import com.tarena.dao.impl.AddressDaoImpl;
import com.tarena.dao.impl.OrderDaoImpl;
import com.tarena.entity.Address;
import com.tarena.entity.CartItem;
import com.tarena.entity.Order;
import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;

public class SuccessAction extends BaseAction {
	private Address address;
	private IOrderDao orderDao = new OrderDaoImpl();
	private IAddressDao iaddressDao = new AddressDaoImpl();
	private int orderId;
	private double dangCost;
	public String execute() {
		User user = (User) session.get("user");

		Order order = new Order();
		order.setUserId(user.getId());
		order.setReceiveName(address.getReceiveName());
		order.setFullAddress(address.getFullAddress());
		order.setPostalCode(address.getPostalCode());
		order.setMobile(address.getMobile());
		order.setPhone(address.getPhone());
		Long orderTime = System.currentTimeMillis();
		order.setOrderTime(orderTime);

		order.setTotalPrice(dangCost);
		order.setStatus(1);
		try {
			address.setUserId(user.getId());
			if (address.getId() == 0) {
				iaddressDao.addAddress(address);
			}
			orderId = orderDao.addOrder(order);
			List<CartItem> cartItems = (List<CartItem>) session.get("cart");
			session.put("cartList", null);
			return "order_ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	public double getDangCost() {
		return dangCost;
	}

	public void setDangCost(double dangCost) {
		this.dangCost = dangCost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
