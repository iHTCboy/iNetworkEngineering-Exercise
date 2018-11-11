package com.tarena.dao;

import java.util.List;

import com.tarena.entity.Category;

public interface ICategoryDao {
	/**
	 * 显示列表信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Category> showCategory() throws Exception;

	/**
	 * 根据父选项显示列表信息
	 * 
	 * @param category
	 * @return
	 * @throws Exception
	 */
	List<Category> findCategoryByParentId(Category category) throws Exception;
	Category findCategoryById(int id) throws Exception ;
}
