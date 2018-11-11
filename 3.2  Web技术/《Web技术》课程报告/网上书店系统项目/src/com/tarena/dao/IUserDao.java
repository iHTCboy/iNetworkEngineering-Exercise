package com.tarena.dao;

import com.tarena.entity.Book;
import com.tarena.entity.User;

public interface IUserDao {
	/**
	 * 添加用户
	 */
	int saveUser(User user) throws Exception;
	User findUserByEmail(String email ,String password) throws Exception;
	User findUserByEmail(String email) throws Exception ;
}