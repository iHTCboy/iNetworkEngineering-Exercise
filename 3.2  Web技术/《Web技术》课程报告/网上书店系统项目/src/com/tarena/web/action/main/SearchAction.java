package com.tarena.web.action.main;

import java.util.List;

import com.tarena.dao.IBookDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.entity.Book;
import com.tarena.entity.Page;

public class SearchAction {
	private String key;
	private IBookDao ibookDao = new BookDaoImpl();
	private Page page = new Page();
	private List<Book> books;
	public String execute(){
		try {
			String key2 = "%"+key+"%"; 
			books = ibookDao.findBookByKey(key2, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			return "error";
		}
		return "book_list";
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	                                               
}
