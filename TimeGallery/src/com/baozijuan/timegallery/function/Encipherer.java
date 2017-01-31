package com.baozijuan.timegallery.function;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encipherer {

	private static final String ALGORITHM = "AES";
	private static final String KEY = "BaoZiJuan19960606BaoCong19960723";
	private static Encipherer encipherer = new Encipherer();

	private Encipherer() {
	}

	public static Encipherer getInstance() {
		return encipherer;
	}

	public String encrypt(String content) throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		Key secureKey = getSecretKey(KEY);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secureKey, secureRandom);
		byte[] data = cipher.doFinal(content.getBytes());
		return new BASE64Encoder().encode(data);
	}

	public String decrypt(String content) throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		Key secureKey = getSecretKey(KEY);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secureKey, secureRandom);
		byte[] data = new BASE64Decoder().decodeBuffer(content);
		return new String(cipher.doFinal(data), "UTF-8");
	}

	private Key getSecretKey(String key) throws Exception {
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(key.getBytes());
		KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
		keyGenerator.init(128, secureRandom);
		return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), ALGORITHM);
	}

}
