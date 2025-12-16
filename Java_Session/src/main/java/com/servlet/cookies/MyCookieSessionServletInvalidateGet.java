package com.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyCookieSessionServletInvalidateGet")
public class MyCookieSessionServletInvalidateGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String output = "";

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {

				// cookie.setValue(null); // Clear the cookie value. This is optional
				cookie.setMaxAge(0); // Set Max-Age to 0 for immediate deletion
				response.addCookie(cookie);

			}

			output = """
					<html>
					    <body>
					        <h2>MyCookieSessionServletInvalidateGet</h2>
					        <h3>cookie Invalidated</h3>
					    </body>
					</html>
					     """;

			out.print(output);

		} else {

			output = """
					<html>
					    <body>
					        <h2>MyCookieSessionServletInvalidateGet</h2>
					        <h3>No cookies found to invalidate</h3>
					    </body>
					</html>
					     """;

			out.print(output);

		}

	}
}
