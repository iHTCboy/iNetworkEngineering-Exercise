package com.tarena.web.action.order;

import java.util.ArrayList;
import java.util.List;

import com.tarena.entity.CartItem;
import com.tarena.web.action.BaseAction;

public class OrderListAction extends BaseAction{
	List<CartItem> cartList = new ArrayList<CartItem>();
	private double totalAccount;
	public String execute(){
		if (session.get("cartList") != null) {
			cartList = (List<CartItem>) session.get("cartList");
		} else {
			session.put("cartList", cartList);
		}
		for (CartItem item : cartList) {
			if(item.isType()){
				
				totalAccount += item.getQty() * item.getBook().getDangPrice();
			}
		}
		if(totalAccount==0){
			return "cartListAction";
		}
		return "order_info";
	}
	public double getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(double totalAccount) {
		this.totalAccount = totalAccount;
	}
	
}
