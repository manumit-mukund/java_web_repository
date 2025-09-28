package com.jwt;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JwtCreateToken {

	private static final String SECRET_KEY = "manu"; // Keep this secure!

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
					.withIssuedAt(issuedAt)
					.withExpiresAt(expiresAt)
					.sign(algorithm);
			
			//ISc-IES: Just to memorize the above sequence

			return token;

		} catch (JWTCreationException exception) {

			// Invalid Signing configuration / Couldn't convert Claims.
			System.err.println("Error creating JWT: " + exception.getMessage());

			return null;

		}
	}

}
