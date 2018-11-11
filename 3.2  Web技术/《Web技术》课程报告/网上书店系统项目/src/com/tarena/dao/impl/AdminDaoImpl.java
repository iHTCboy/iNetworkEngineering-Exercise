package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tarena.dao.IAdminDao;
import com.tarena.dao.IUserDao;
import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.entity.Admins;
import com.tarena.util.datasource.DBConnection;

public class AdminDaoImpl  implements IAdminDao {

	public Admins findUser(String LoginName ,String password) throws Exception{
		Admins admins = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_admins where LoginName=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, LoginName);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				admins = new Admins();
				admins.setLoginName(rs.getString("LoginName"));
				admins.setAdminID(rs.getInt("AdminID"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(rs, ps,conn);
				}
		return admins;
	}

	public Admins findUserByEmail(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
