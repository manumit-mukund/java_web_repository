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
		String username1 = "username1 not found";
		String username2 = "username2 not found";
		String username3 = "username3 not found";

		if (session != null) {

			sessionId = "session accessed: " + session.getId();

			// Retrieve the username attribute from the session
			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");
		}

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyHttpSessionServletSet</h2>
				        <p>username attribute accessed from the session</p>
				        """;

		output += "<p>sessionId = " + sessionId + "</p>";

		output += "<p>username1 = " + username1 + "</p>";
		output += "<p>username2 = " + username2 + "</p>";
		output += "<p>username3 = " + username3 + "</p>";
		output += "</body></html>";

		out.print(output);

	}

//	Syntax for formatted strings in Java 15 and later:
//	String output = """
//	<html>
//	    <body>
//	        <h2>MyHttpSessionServletGet</h2>
//	        <h3>username = %s</h3>
//	    </body>
//
//	     """.formatted(username);
}
