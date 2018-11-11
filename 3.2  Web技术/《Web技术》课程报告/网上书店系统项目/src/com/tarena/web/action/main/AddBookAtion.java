package com.tarena.web.action.main;

import com.tarena.dao.IBookDao;
import com.tarena.dao.IUserDao;
import com.tarena.dao.impl.BookDaoImpl;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.entity.Product;
import com.tarena.entity.Category;
import com.tarena.util.code.EmailCode;
import com.tarena.web.action.BaseAction;

public class AddBookAtion extends BaseAction {
	private User user;
	private Book book;
	private Product product;
	private Category category;
	private IUserDao iuserDao = new UserDaoImpl();
	private IBookDao ibookDao = new BookDaoImpl();
	private String number;

	public String execute() {
		
		try {
			
				int id = ibookDao.addBook(product.getProductName(),
						product.getFixedPrice(),
						product.getDangPrice(),
						category.getId(),
						product.getDescription(),
						book.getPublishing(),
						book.getPublishTime(),
						book.getAuthor());
				if (id > 0) {
					session.put("user", user);
					return "ok";
				
			}
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public Book getBook() {
		return book;
	}

	public void setBook() {
		this.book = book;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct() {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory() {
		this.category = category;
	}

	

}
