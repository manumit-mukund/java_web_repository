package com.servlet.rewriting;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletOne extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String userName = request.getParameter("userName");
			out.print("Welcome " + userName + "<br>");

			// appending the username in the query string
			// username can be get in the next servlet by
			// using its key uname
			out.print("<a href='welcome?uname=" + userName + "'>Click Here</a>");

			out.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}
}