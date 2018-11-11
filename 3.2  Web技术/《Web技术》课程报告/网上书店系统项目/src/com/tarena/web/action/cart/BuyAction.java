package com.tarena.web.action.cart;

import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.IBookDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.entity.CartItem;
import com.tarena.web.action.BaseAction;

public class BuyAction extends BaseAction {
	IBookDao ibookDao = new BookDaoImpl();
	List<CartItem> cartList = new ArrayList<CartItem>();
	private int id;
	private double totalEconomy;
	private double totalAccount;

	public String execute() {
		if (session.get("cartList") != null) {
			cartList = (List<CartItem>) session.get("cartList");
		} else {
			session.put("cartList", cartList);
		}
		try {
			boolean hasCartItem = false;
			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getBook().getId() == id) {
					cartList.get(i).setQty(cartList.get(i).getQty() + 1);
					cartList.get(i).setType(true);
					hasCartItem = true;
				}
			}
			if (!hasCartItem) {
				CartItem cartItem = new CartItem();
				cartItem.setBook(ibookDao.findBookById(id));
				cartItem.setQty(1);
				cartItem.setType(true);
				cartList.add(cartItem);
			}
			session.put("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		for (CartItem item : cartList) {
			if(item.isType()){
				totalEconomy += (item.getBook().getFixedPrice() - item.getBook()
						.getDangPrice())
						* item.getQty();
				totalAccount += item.getQty() * item.getBook().getDangPrice();
			}
			
		}
		return "cartListAction";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalEconomy() {
		return totalEconomy;
	}

	public void setTotalEconomy(double totalEconomy) {
		this.totalEconomy = totalEconomy;
	}

	public double getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(double totalAccount) {
		this.totalAccount = totalAccount;
	}
	
}
