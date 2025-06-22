package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyHttpSessionServleInvalidate")
public class MyHttpSessionServleInvalidate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the HttpSession object
		HttpSession session = request.getSession(false); // Use false to avoid creating a new session if it doesn't
															// exist);

		// Invalidate the session

		String output = "session not found";

		if (session != null) {

			session.invalidate();

			output = """
					<html>
					    <body>
					        <h2>MyHttpSessionServleInvalidate</h2>
					        <p>The session has been invalidated.</p>
					    </body>
					</html>
					     """;
		}

		PrintWriter out = response.getWriter();

		out.print(output);

	}
}
