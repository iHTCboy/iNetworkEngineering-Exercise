package com.tarena.util.code;

import java.util.UUID;

public class EmailCode {
	public static String createEmailCode() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
