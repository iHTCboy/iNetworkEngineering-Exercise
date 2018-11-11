package com.tarena.web.action.main;

import java.util.List;

import com.tarena.dao.IBookDao;
import com.tarena.dao.ICategoryDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.dao.impl.CategoryDaoImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.entity.Page;

public class BookListAction {
	private Category category;
	private ICategoryDao icategoryDao = new CategoryDaoImpl();
	private IBookDao ibookDao = new BookDaoImpl();
	private List<Category> categorys;
	private int totalnum;
	private Page page = new Page();
	private List<Book> books;
	private String yourPosition;

	public String execute() {
		try {
			categorys = icategoryDao.findCategoryByParentId(category);
			for (Category c : categorys) {
				totalnum += c.getCountProduct();
			}
			books = ibookDao.findBookByCatId(category, page);
			yourPosition = icategoryDao.findCategoryById(category.getParentId()).getName();
			return "book_list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public String getYourPosition() {
		return yourPosition;
	}

	public void setYourPosition(String yourPosition) {
		this.yourPosition = yourPosition;
	}
	
}
