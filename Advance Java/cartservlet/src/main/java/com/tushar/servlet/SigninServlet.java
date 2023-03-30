package com.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tushar.connection.DBConnection;
import com.tushar.dbobj.UserDbObj;
import com.tushar.model.User;

public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("signin.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Signin</title>");
			out.println("</head>");
			out.println("<body>");

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserDbObj userDbObj = new UserDbObj(DBConnection.getConnection());
			User user = userDbObj.userLogin(email, password);
			
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				System.out.println("User Login");
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("user not found");
			}
			
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
