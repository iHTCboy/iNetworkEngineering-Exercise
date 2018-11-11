package com.tarena.util.code;

import java.security.MessageDigest;

import 

sun.misc.BASE64Encoder;

public class Md5Code {
	public static String 

createMd5Code(String code) throws Exception{
		//获取Md5对象
		

MessageDigest digest = MessageDigest.getInstance("MD5");
		//字符串转换成hashcode值
		byte[] b = digest.digest(code.getBytes());
		

//sun公司公开算法,不安全,不建议使用
		BASE64Encoder encoder = new 

BASE64Encoder();
		return encoder.encode(b);
	}
}
