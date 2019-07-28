package org.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public final class Encryptor {
	
	private Encryptor() {}
	
	public static final String encrypt(String str) {
		try {
			final MessageDigest md = MessageDigest.getInstance("SHA-256");
			final byte[] bytes = md.digest(str.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to encrypt");
		}
	}
	
}
