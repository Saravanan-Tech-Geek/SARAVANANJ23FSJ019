package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("*.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		ServletOutputStream out = response.getOutputStream();
		
		if(uname.equalsIgnoreCase("jaga")&& upass.equalsIgnoreCase("secret")) {
			//response.sendRedirect("welcome.html");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		} else if((uname.equalsIgnoreCase("jaga")&& !upass.equalsIgnoreCase("secret"))) {
			out.println("Your password is incorrect,please try again!!");
		}
		else {
			//response.sendRedirect("register.html");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
