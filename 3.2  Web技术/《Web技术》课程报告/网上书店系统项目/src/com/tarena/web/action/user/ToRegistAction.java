package com.tarena.web.action.user;

import com.tarena.dao.IUserDao;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.User;
import com.tarena.util.code.EmailCode;
import com.tarena.web.action.BaseAction;

public class ToRegistAction extends BaseAction {
	private User user;
	private IUserDao iuserDao = new UserDaoImpl();
	private String number;

	public String execute() {
		
		try {
			
				int id = iuserDao.saveUser(user);
				if (id > 0) {
					session.put("user", user);
					return "register_ok";
				
			}
			return "register_form";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
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

}
