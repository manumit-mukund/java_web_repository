package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyHttpSessionServletSet")
public class MyHttpSessionServletSet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the HttpSession object
		HttpSession session = request.getSession();

		// Use HttpSession methods
		session.setAttribute("username", "manu");

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyHttpSessionServletSet</h2>
				        <p>username attribute added to the session.</p>
				    </body>
				</html>
				     """;

		out.print(output);

	}
}
