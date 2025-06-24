package com.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyCookieSessionServletSet")
public class MyCookieSessionServletSet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie sessionCookie1 = new Cookie("sessionId1", "123456");
		Cookie sessionCookie2 = new Cookie("sessionId2", "1234566");
		Cookie sessionCookie3 = new Cookie("sessionId3", "12345666");

		// Set cookie's max age to 1 minute (60 seconds)
		sessionCookie1.setMaxAge(60);
		response.addCookie(sessionCookie1);
		response.addCookie(sessionCookie2);
		response.addCookie(sessionCookie3);

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyCookieSessionServletSet</h2>
				        <p>Cookie sessionId added to the response.</p>
				    </body>
				</html>
				     """;

		out.print(output);

	}
}
