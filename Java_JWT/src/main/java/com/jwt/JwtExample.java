package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JwtExample {

	private static final String SECRET_KEY = "manu"; // Keep this secure!

	public static void main(String[] args) {

		String token = createJwtToken();

		System.out.println("Generated JWT: " + token);

		verifyJwtToken(token);

	}

	public static String createJwtToken() {

		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			Date issuedAt = new Date();
			Date expiresAt = new Date(issuedAt.getTime() + TimeUnit.MINUTES.toMillis(30)); // Token expires in 30
																							// minutes

			String token = JWT
					.create()
					.withIssuer("auth0")
					.withSubject("user123") // Subject of the token
					.withClaim("role", "admin") // Custom claim
					.withIssuedAt(issuedAt).withExpiresAt(expiresAt).sign(algorithm);

			return token;

		} catch (JWTCreationException exception) {

			// Invalid Signing configuration / Couldn't convert Claims.
			System.err.println("Error creating JWT: " + exception.getMessage());

			return null;

		}
	}

	public static void verifyJwtToken(String token) {

		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			
			JWTVerifier verifier = JWT
					.require(algorithm)
					.withIssuer("auth0")
					.build(); // Reusable verifier instance
			
			DecodedJWT jwt = verifier.verify(token);

			System.out.println("\nJWT Verified Successfully!");
			System.out.println("\nSubject: " + jwt.getSubject());
			System.out.println("\nRole: " + jwt.getClaim("role").asString());
			System.out.println("\nExpires At: " + jwt.getExpiresAt());

		} catch (JWTVerificationException exception) {

			// Invalid signature/claims
			System.err.println("Error verifying JWT: " + exception.getMessage());

		}
	}
}