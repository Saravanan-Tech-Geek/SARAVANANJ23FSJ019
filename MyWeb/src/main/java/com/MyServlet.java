package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.gold")
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called...!");
		String username = request.getParameter("uname");
		String coachname = request.getParameter("coach");
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.print("<h1>"+ "welcome coach " + coachname + " by " + username + "<h1>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do post called...!");
		doGet(request, response);
	}

}
