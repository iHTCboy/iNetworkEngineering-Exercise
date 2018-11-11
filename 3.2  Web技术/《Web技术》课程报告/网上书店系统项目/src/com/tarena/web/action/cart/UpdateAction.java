package com.tarena.web.action.cart;

import java.util.ArrayList;
import java.util.List;

import com.tarena.entity.CartItem;
import com.tarena.web.action.BaseAction;

public class UpdateAction extends BaseAction{
	private int id;
	private int qty;
	private double totalEconomy;
	private double totalAccount;
	List<CartItem> cartList = new ArrayList<CartItem>();
	public String execute(){
		cartList = (List<CartItem>) session.get("cartList");
		for(int i= 0;i<cartList.size();i++){
			if(cartList.get(i).getBook().getId()==id){
				cartList.get(i).setQty(qty);
			}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
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
