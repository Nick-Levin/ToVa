package org;

import java.util.UUID;

import org.util.Encryptor;

public class Demo {
	
	public static void main(String[] args) {
		
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		System.out.println("UUID length: " + UUID.randomUUID().toString().length());
		
		System.out.println("==============================================");
		
		System.out.println("HASH length: " + Encryptor.encrypt("secret"));
		System.out.println("HASH length: " + Encryptor.encrypt("sdfsdf"));
		System.out.println("HASH length: " + Encryptor.encrypt("dfsfdg").length());
		System.out.println("HASH length: " + Encryptor.encrypt("ghshgsadhjsdfgh").length());
		System.out.println("HASH length: " + Encryptor.encrypt("bjknsjkhb").length());
		System.out.println("HASH length: " + Encryptor.encrypt("hello world").length());
		System.out.println("HASH length: " + Encryptor.encrypt("fdsgsdg").length());
		System.out.println("HASH length: " + Encryptor.encrypt("2411fdh35g1").length());
		System.out.println("HASH length: " + Encryptor.encrypt("hsdth153d135dfg3").length());
		
	}
	
}
