package com.tarena.web.action.user;

import com.tarena.dao.IUserDao;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;

public class ToLoginAction extends BaseAction {
	private String email;
	private String password;
	private User user = null;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private IUserDao iuserDao = new UserDaoImpl();

	public String execute() {
		try {
			user = new User();
			user = iuserDao.findUserByEmail(email, password);
			if (user != null) {
				session.put("user", user);
				return "main";
			} else {
				return "login_form";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}
}
