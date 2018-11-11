package com.tarena.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	/**
	 * 商品
	 */
	private Book book;
	/**
	 * 商品数量
	 */
	private int qty;
	/**
	 * type=true选购商品；type=false	移除商品
	 */
	private boolean type = true;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

}
