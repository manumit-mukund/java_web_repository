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

		String sessionId = "";
		String username1 = "";
		String username2 = "";
		String username3 = "";

		if (session.isNew()) {

			sessionId = "New session created: " + session.getId();

			// Use HttpSession methods
			session.setAttribute("username1", "manu1");
			session.setAttribute("username2", "manu2");
			session.setAttribute("username3", "manu3");

			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");

		} else {

			sessionId = "Existing session accessed: " + session.getId();
			username1 = (String) session.getAttribute("username1");
			username2 = (String) session.getAttribute("username2");
			username3 = (String) session.getAttribute("username3");

		}

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyHttpSessionServletSet</h2>
				        <p>username attribute added to the session</p>""";

		output += "<p>sessionId = " + sessionId + "</p>";

		output += "<p>username1 = " + username1 + "</p>";
		output += "<p>username2 = " + username2 + "</p>";
		output += "<p>username3 = " + username3 + "</p>";

		output += "</body></html>";

		out.print(output);

	}
}
