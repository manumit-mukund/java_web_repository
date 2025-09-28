package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtVerifyToken {

	private static final String SECRET_KEY = "manu"; // Keep this secure!

	public static void verifyJwtToken(String token) {

		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

			JWTVerifier verifier = JWT
					.require(algorithm)
					.withIssuer("auth0")
					.build(); // Reusable verifier instance

			DecodedJWT decodedJWT = verifier.verify(token);

			System.out.println("\nJWT Verified Successfully!");
			System.out.println("\nSubject: " + decodedJWT.getSubject());
			System.out.println("\nRole: " + decodedJWT.getClaim("role").asString());
			System.out.println("\nExpires At: " + decodedJWT.getExpiresAt());

		} catch (JWTVerificationException exception) {

			// Invalid signature/claims
			System.err.println("Error verifying JWT: " + exception.getMessage());

		}
	}
}
