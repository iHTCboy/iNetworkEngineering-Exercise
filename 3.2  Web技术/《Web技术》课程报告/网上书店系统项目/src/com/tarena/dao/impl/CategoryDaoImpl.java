package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ICategoryDao;
import com.tarena.entity.Category;
import com.tarena.util.datasource.DBConnection;

public class CategoryDaoImpl implements ICategoryDao {
	/**
	 * 查询所有产品种类
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Category> findAllCategory() throws Exception {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_category";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setEnName(rs.getString("en_name"));
				category.setName(rs.getString("name"));
				category.setTurn(rs.getInt("turn"));
				category.setParentId(rs.getInt("parent_id"));
				category.setDescription(rs.getString("description"));
				categorys.add(category);
			}

		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return categorys;
	}
	
	public Category findCategoryById(int id) throws Exception {
		Category category = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_category where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setEnName(rs.getString("en_name"));
				category.setName(rs.getString("name"));
				category.setTurn(rs.getInt("turn"));
				category.setParentId(rs.getInt("parent_id"));
				category.setDescription(rs.getString("description"));
			}

		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return category;
	}

	/**
	 * 获取子标题
	 * 
	 * @param categoryAll
	 * @param id
	 * @return
	 */
	public List<Category> subCategory(List<Category> categoryAll, int id) {
		List<Category> subCategorys = new ArrayList<Category>();
		for (Category category : categoryAll) {
			if (category.getParentId() == id) {
				subCategorys.add(category);
			}
		}
		return subCategorys;
	}

	public List<Category> findCategoryByParentId(Category category)
			throws Exception {
		List<Category> categorys = new ArrayList<Category>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select  c.name,c.id,c.parent_id,count(cp.product_id) count_product from d_category c left join  d_category_product cp  on c.id=cp.cat_id where c.parent_id=? group by c.name,c.id,c.parent_id";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getParentId());
			rs = ps.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("name"));
				cate.setParentId(rs.getInt("parent_id"));
				// 在Category添加一个countProduct
				cate.setCountProduct(rs.getInt("count_product"));
				categorys.add(cate);

			}
		} finally {
			DBConnection.close(rs, ps, conn);
		}

		return categorys;
	}

	/**
	 * 显示列表
	 */
	public List<Category> showCategory() throws Exception {
		List<Category> categoryAll = this.findAllCategory();
		List<Category> categorys = this.subCategory(categoryAll, 1);
		for (Category category : categorys) {
			List<Category> subCategorys = this.subCategory(categoryAll,
					category.getId());
			category.setSubCategorys(subCategorys);
		}

		return categorys;
	}

}
