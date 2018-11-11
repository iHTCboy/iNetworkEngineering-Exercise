package com.tarena.web.action.user;

import java.io.InputStream;

import com.tarena.util.code.ValidateCode;
import com.tarena.web.action.BaseAction;

public class ValidateCodeAction extends BaseAction{
	private InputStream is;
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String execute(){
		ValidateCode validateCode = new ValidateCode();
		try{
			is = validateCode.getCode(session);
			return "show_image";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}
}
