package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyHttpSessionServletGet")
public class MyHttpSessionServletGet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve the HttpSession object
		HttpSession session = request.getSession(false); // Use false to avoid creating a new session if it doesn't
															// exist);

		String sessionId = "sessionId not found";
		String username = "username not found";

		if (session != null) {

			sessionId = "session accessed: " + session.getId();

			// Retrieve the username attribute from the session
			username = (String) session.getAttribute("username");
		}

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyHttpSessionServletGet</h2>
				        <h3>username = %s</h3>
				    </body>

				     """.formatted(username);

		output += "<p>sessionId = " + sessionId + "<p></html>";

		out.print(output);

	}
}
