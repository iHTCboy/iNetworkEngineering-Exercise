package com.tarena.dao;

import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.entity.Admins;

public interface IAdminDao {
	/**
	 * 添加用户
	 */
	//int saveUser(User user) throws Exception;
	Admins findUser(String LoginName ,String password) throws Exception;
	Admins findUserByEmail(String LoginName) throws Exception ;
}