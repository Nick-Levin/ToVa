package org.auth;

import java.util.Date;

import org.pojo.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public final class Authenticator {
	
	private static final Algorithm ALG = Algorithm.HMAC256("Made-By-Valard");
	private static final String ISSUER = "North-Tom-Server";
	
	private Authenticator() {}
	
	public static String createToken(final User user) {
		try {
			return JWT.create()
				.withIssuedAt(new Date())
				.withIssuer(ISSUER)
				.withClaim("username", user.getUsername())
				.withClaim("email", user.getEmail())
				.withClaim("id", user.getId().toString())
				.sign(ALG);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to create Token");
		}
	}
	
	public static DecodedJWT Validate(final String token) {
		try {
			final JWTVerifier verifier = JWT.require(ALG).withIssuer(ISSUER).build();
			return verifier.verify(token);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new RuntimeException("[ERROR]: Failed to validate the token");
		}
	}
	
}








