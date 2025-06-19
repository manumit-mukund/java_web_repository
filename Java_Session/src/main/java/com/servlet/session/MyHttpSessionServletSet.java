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

		String sessionId = "sessionId not found";

		if (session.isNew()) {

			sessionId = "New session created: " + session.getId();

			// Use HttpSession methods
			session.setAttribute("username", "manu");

		} else {

			sessionId = "Existing session accessed: " + session.getId();

		}

		PrintWriter out = response.getWriter();

		String output = """
				<html>
				    <body>
				        <h2>MyHttpSessionServletSet</h2>
				        <p>username attribute added to the session</p>""";
		
		output += "<p>sessionId = " + sessionId + "<p><br>";

		output += "</body></html>";

		out.print(output);

	}
}
