package com.tarena.web.action.user;


import com.tarena.dao.IAdminDao;
import com.tarena.dao.impl.AdminDaoImpl;
import com.tarena.entity.Admins;
import com.tarena.web.action.BaseAction;

public class ToAdminAction extends BaseAction {
	private String LoginName;
	private String password;
	private Admins admins = null;

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String LoginName) {
		this.LoginName = LoginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private IAdminDao iAdminDao = new AdminDaoImpl();

	public String execute() {
		try {
			admins = new Admins();
			admins = iAdminDao.findUser(LoginName, password);
			if (admins != null) {
				session.put("admins", admins);
				return "adminMain";
			} else {
				return "adminLogin";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}
}