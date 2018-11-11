package com.tarena.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {

	public Category() {

	}

	private int id;

	/**
	 * 显示顺序(*)
	 */
	private int turn;

	/**
	 * 英文名字
	 */
	private String enName;

	/**
	 * 中文名字
	 */
	private String name;

	/**
	 * 种类描述(*)
	 */
	private String description;

	/**
	 * 父类项
	 */
	private int parentId;

	/**
	 * 二级标题
	 */
	private List<Category> subCategorys = new ArrayList<Category>();

	/**
	 * 产品总数
	 */
	private int countProduct;

	public int getCountProduct() {
		return countProduct;
	}

	public void setCountProduct(int countProduct) {
		this.countProduct = countProduct;
	}

	public List<Category> getSubCategorys() {
		return subCategorys;
	}

	public void setSubCategorys(List<Category> subCategorys) {
		this.subCategorys = subCategorys;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

}
