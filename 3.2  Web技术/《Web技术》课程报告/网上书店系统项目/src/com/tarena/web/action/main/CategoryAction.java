package com.tarena.web.action.main;

import java.util.List;

import com.tarena.dao.ICategoryDao;
import com.tarena.dao.impl.CategoryDaoImpl;
import com.tarena.entity.Category;

public class CategoryAction {
	private ICategoryDao icategoryDao = new CategoryDaoImpl();
	private List<Category> categorys;

	public String execute() {
		try {
			categorys = icategoryDao.showCategory();
			return "category";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
