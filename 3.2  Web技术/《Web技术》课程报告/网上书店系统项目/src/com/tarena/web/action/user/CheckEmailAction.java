package com.tarena.web.action.user;

import com.tarena.dao.IUserDao;
import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.User;

public class CheckEmailAction {
	private boolean iscode;
	private IUserDao iuserdao = new UserDaoImpl();
	private String email;
	public String execute(){
		try {
			//根据email获得用户user
			User user1 = iuserdao.findUserByEmail(email);
			if(user1 != null){
				iscode = false;
			}else{
				iscode = true;
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	
	}
	public boolean isIscode() {
		return iscode;
	}
	public void setIscode(boolean iscode) {
		this.iscode = iscode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
