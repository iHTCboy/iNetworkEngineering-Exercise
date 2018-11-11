package com.tarena.web.action.main;

import java.util.Random;

import com.tarena.dao.IBookDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.entity.Book;

public class RecommendAction {
	private Book book1;
	private Book book2;
	private IBookDao ibookDao = new BookDaoImpl();
	
	public String execute() {
		// 调用DAO
		try {
			Random r = new Random();
			book1 = ibookDao.findBookById(r.nextInt(23)+1);
			book2 = ibookDao.findBookById(r.nextInt(23)+1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "recommend";
	}

	public Book getBook1() {
		return book1;
	}

	public void setBook1(Book book1) {
		this.book1 = book1;
	}

	public Book getBook2() {
		return book2;
	}

	public void setBook2(Book book2) {
		this.book2 = book2;
	}
	
}
