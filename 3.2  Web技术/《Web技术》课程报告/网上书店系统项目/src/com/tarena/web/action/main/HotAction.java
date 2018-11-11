package com.tarena.web.action.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tarena.dao.IBookDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.entity.Book;

public class HotAction {
	private List<Book> books = new ArrayList<Book>();
	private static int num = 4;
	private IBookDao ibookDao = new BookDaoImpl();

	public String execute() {
		// 调用DAO
		try {
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				Book book = ibookDao.findBookById(r.nextInt(23) + 1);
				books.add(book);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		return "hot";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
