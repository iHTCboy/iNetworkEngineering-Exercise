package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tarena.dao.IUserDao;
import com.tarena.entity.Book;
import com.tarena.entity.User;
import com.tarena.util.code.Md5Code;
import com.tarena.util.datasource.DBConnection;

public class UserDaoImpl implements IUserDao {
	/**
	 * 添加用户
	 * 
	 * @throws Exception
	 */
	public int saveUser(User user) throws Exception {
		int id = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into d_user(email,nickname,password,is_email_verify,email_verify_code)values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getNickname());
			ps.setString(3, Md5Code.createMd5Code(user.getPassword()));
			ps.setString(4, user.isEmailVerify() ? "Y" : "N");
			ps.setString(5, user.getEmailVerifyCode());
			int result = ps.executeUpdate();
			if (result > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return id;
	}
	public User findUserByEmail(String email ,String password) throws Exception{
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_user where email=? and password=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Md5Code.createMd5Code(password));
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setId(rs.getInt("id"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBConnection.close(rs, ps,conn);
		}
		return user;
	}
	public User findUserByEmail(String email) throws Exception {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from d_user where email=? ";
		//获得数据连接
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,email);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setPassword(rs.getString("password"));
				user.setEmailVerifyCode(rs.getString("email_verify_code"));
				user.setId(rs.getInt("id"));				
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			//关闭数据
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return user;
	}
}
