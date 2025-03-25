package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/VulnerableServlet")
public class VulnerableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");

		String param = request.getParameter("param");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2>VulnerableServlet</h2>");
		out.print("</body></html>");

		if (param != null) {

			for (int i = 0; i < Integer.MAX_VALUE; i++) {

				response.getWriter().write("Response " + i + "\n");

			}
		}

	}
}
