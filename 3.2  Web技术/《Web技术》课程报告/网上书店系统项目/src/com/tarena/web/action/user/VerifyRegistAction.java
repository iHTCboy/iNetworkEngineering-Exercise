package com.tarena.web.action.user;

import com.tarena.entity.User;
import com.tarena.web.action.BaseAction;

public class VerifyRegistAction extends BaseAction{
	private String code;
	private User user;
	public String execute(){
		user = (User)session.get("user");
		if(user.getEmailVerifyCode().equals(code)){
			return "register_ok";
		}else{
			return "verify_form";
		}
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
