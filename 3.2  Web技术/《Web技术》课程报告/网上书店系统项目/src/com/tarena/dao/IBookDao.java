package com.tarena.dao;

import java.util.List;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.entity.Page;
import com.tarena.entity.Product;

public interface IBookDao {
	List<Book> findBookByCatId(Category category,Page page)throws Exception;
	Book findBookById(int id) throws Exception;
	List<Book> findBookByKey(String key,Page page) throws Exception;
	int addBook(String product_name,
			double fixed_price,
			double dang_price,
			int id,
			String description,
			String publishing,
			String publish_time,
			String author)throws Exception;
}
