package net.civilis.playground.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletBase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		processRequest(request, response);
	}

	protected abstract void processRequest(HttpServletRequest request,
			HttpServletResponse response)  throws IOException;


}
