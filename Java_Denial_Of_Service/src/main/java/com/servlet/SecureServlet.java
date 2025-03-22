package com.servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.tomcat.jakartaee.commons.lang3.StringUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SecureServlet")
public class SecureServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int MAX_REQUESTS_PER_SECOND = 1;
	private AtomicInteger requestCount = new AtomicInteger(0);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (requestCount.incrementAndGet() > MAX_REQUESTS_PER_SECOND) {

			response.sendError(HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Too many requests");
			return;

		}

		String param = request.getParameter("param");

		if (StringUtils.isNumeric(param)) {

			int limit = Integer.parseInt(param);
			
			if (limit > 1000) {
				
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Request limit exceeded");
				return;
				
			}

			for (int i = 0; i < limit; i++) {
				
				response.getWriter().write("Response " + i + "\n");
				
			}
			
		} else {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
			
		}

		requestCount.decrementAndGet();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		new Thread(() -> {
			while (true) {
				requestCount.set(0);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}