package com.baozijuan.timegallery.function;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class Validator {

	private static final String ALGORITHM = "MD5";
	
	private static MessageDigest md;

	private Validator() {
	}
	
	public static String calculate(String md5pass, String username) throws Exception {
		final int salt = username.hashCode();
		final byte[] salted = (md5pass + salt).getBytes();
		md = MessageDigest.getInstance(ALGORITHM);
		md.update(salted);
		return new BASE64Encoder().encode(md.digest());
	}

}
