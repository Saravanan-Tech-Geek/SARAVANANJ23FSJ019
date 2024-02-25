package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
@WebServlet("/SessionDemo2")
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		HttpSession session = request.getSession();
		if (session.isNew()) {
			out.println("<h1>You are visiting for the first time...</h1>");
			session.setAttribute("count", 2);
		} else {
			String c = session.getAttribute("count").toString();
			out.println("<h1>You are visiting for the ..." + c + "times...</h1>");
			int nc = Integer.parseInt(c);
			session.setAttribute("count", ++nc);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
