package com.tarena.web.action.cart;

import java.util.ArrayList;
import java.util.List;

import com.tarena.entity.CartItem;
import com.tarena.web.action.BaseAction;

public class CartListAction extends BaseAction {
	List<CartItem> cartList = new ArrayList<CartItem>();
	private double totalEconomy;
	private double totalAccount;

	public String execute() {
		if (session.get("cartList") != null) {
			cartList = (List<CartItem>) session.get("cartList");
		} else {
			session.put("cartList", cartList);
		}
		for (CartItem item : cartList) {
			if(item.isType()){
				totalEconomy += (item.getBook().getFixedPrice() - item.getBook()
						.getDangPrice())
						* item.getQty();
				totalAccount += item.getQty() * item.getBook().getDangPrice();
			}
			
		}
		return "cart_list";
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
