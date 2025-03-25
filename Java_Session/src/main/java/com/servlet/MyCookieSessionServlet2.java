package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyCookieSessionServlet2")
public class MyCookieSessionServlet2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyCookieSessionServlet2</h2>
				        <h3>sessionId = %s</h3>
				    </body>
				</html>
				     """.formatted(cookies[0].getValue());

		out.print(output);

	}
}
