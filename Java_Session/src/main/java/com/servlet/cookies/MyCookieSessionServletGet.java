package com.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyCookieSessionServletGet")
public class MyCookieSessionServletGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		String sessionId = "No session cookie found.";

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				if ("sessionId".equals(cookie.getName())) {

					sessionId = cookie.getValue();

					break;

				}
			}
		}

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyCookieSessionServletGet</h2>
				        <h3>sessionId = %s</h3>
				    </body>
				</html>
				     """.formatted(sessionId);

		out.print(output);

	}
}
