package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tarena.dao.IBookDao;
import com.tarena.entity.Book;
import com.tarena.entity.Category;
import com.tarena.entity.Page;
import com.tarena.entity.Product;
import com.tarena.util.code.Md5Code;
import com.tarena.util.datasource.DBConnection;

public class BookDaoImpl implements IBookDao{
	public List<Book> findBookByCatId(Category category,Page page) throws Exception{
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "select p.id,p.product_name,p.description,p.add_time,p.fixed_price,p.dang_price,p.product_pic,b.author,b.publishing,b.publish_time from d_category_product cp inner join d_product p on cp.product_id=p.id inner join d_book b on p.id=b.id where cp.cat_id=? limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getId());
			ps.setInt(2, page.getBegin());
			ps.setInt(3, page.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(new Date(rs.getLong("add_time")));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setProductPic(rs.getString("product_pic"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				
//				book.setAddTime(new Date(rs.getLong("add_time")));
//				book.setAuthorSummary(rs.getString("author_summary"));
				books.add(book);
			}
			page.setCountItem(countBooks(category.getId()));
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return books;
	}
	public int countBooks(int id) throws Exception{
		int countItem = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "select count(*) count_item from d_category_product cp inner join d_product p on cp.product_id=p.id inner join d_book b on p.id=b.id where cp.cat_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				countItem = rs.getInt("count_item");
			}
		
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return countItem;
	}
	public Book findBookById(int id) throws Exception{
		Book book = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "select p.id,p.product_name,p.description,p.add_time,p.fixed_price,p.dang_price,p.product_pic,b.author,b.publishing,b.publish_time from d_category_product cp inner join d_product p on cp.product_id=p.id inner join d_book b on p.id=b.id where p.id=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(new Date(rs.getLong("add_time")));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setProductPic(rs.getString("product_pic"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));

			}
		
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return book;
	}
	public List<Book> findBookByKey(String key,Page page) throws Exception{
		List<Book> books = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			String sql = "select distinct p.id,p.product_name,p.description,p.add_time,p.fixed_price,p.dang_price,p.product_pic,b.author,b.publishing,b.publish_time from d_category_product cp inner join d_product p on cp.product_id=p.id inner join d_book b on p.id=b.id where product_name like "+"'"+key+"'"+"";
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, page.getBegin());
//			ps.setInt(2, page.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(new Date(rs.getLong("add_time")));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setProductPic(rs.getString("product_pic"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(new String("publish_time"));
				
//				book.setAddTime(new Date(rs.getLong("add_time")));
//				book.setAuthorSummary(rs.getString("author_summary"));
				books.add(book);
				
			}
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return books;
	}
	public int addBook(String product_name, double fixed_price,
			double dang_price, int id,String description, String publishing,
			String publish_time, String author) throws Exception {
		// TODO Auto-generated method stub
		int iD = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql1 = "insert into d_product(product_name,fixed_price,dang_price,description)values(?,?,?,?)";
			ps = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, product_name);
			ps.setDouble(2, fixed_price);
			ps.setDouble(3, dang_price);
			ps.setString(4, description);

			String sql = "insert into d_book(publishing,publish_time,author)values(?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, publishing);
			ps.setString(2, publish_time);
			ps.setString(3, author);
			
			String sql3 = "insert into d_category(id)values(?)";
			ps = conn.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);

			int result = ps.executeUpdate();
			if (result > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					iD = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return iD;
	}
		
		
}

