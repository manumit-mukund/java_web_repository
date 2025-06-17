package com.jwt;

public class JwtDemo {

	public static void main(String[] args) {

		String token = JwtCreateToken.createJwtToken();

		System.out.println("Generated JWT: " + token);

		JwtVerifyToken.verifyJwtToken(token);

	}

}