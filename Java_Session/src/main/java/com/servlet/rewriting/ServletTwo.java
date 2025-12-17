package com.servlet.rewriting;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletTwo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// getting value from the query string
			String userName = request.getParameter("uname");
			out.print("Hello " + userName);

			out.close();

		} catch (Exception e) {

			System.out.println(e);

		}
	}
}