package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyCookieSessionServlet1")
public class MyCookieSessionServlet1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie cookie = new Cookie("sessionId", "123456");
		response.addCookie(cookie);

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyCookieSessionServlet1</h2>
				        <p>Cookie sessionId added to the response.</p>
				    </body>
				</html>
				     """;

		out.print(output);

	}
}
