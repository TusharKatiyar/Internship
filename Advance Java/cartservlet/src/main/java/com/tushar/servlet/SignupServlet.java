package com.tushar.servlet;

import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tushar.connection.DBConnection;
import com.tushar.dbobj.UserDbObj;
import com.tushar.model.User;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Signup</title>");
			out.println("</head>");
			out.println("<body>");
			// fetch data from signup page
			int employeeID = Integer.parseInt(request.getParameter("employeeID"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String designation = request.getParameter("designation");
			String contactNumber = request.getParameter("contactNumber");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String address = request.getParameter("address");
			Part filePart = request.getPart("profilePicture");
			byte[] byteArray = filePart.getInputStream().readAllBytes();
			String profilePicture = Base64.getEncoder().encodeToString(byteArray);	
			String link = request.getParameter("link");
			String language = request.getParameter("language");
			String password = request.getParameter("password");

			// make user object
			User user = new User(employeeID, firstName, lastName, designation, contactNumber, email, dob, address,
					profilePicture, link, language, password);

			UserDbObj userDbObj = new UserDbObj(DBConnection.getConnection());

			if (userDbObj.userSignup(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				System.out.println("User registered.");
				response.sendRedirect("index.jsp");
			} else {
				String errorMessage = "User Available";
				HttpSession regSession = request.getSession();
				regSession.setAttribute("RegError", errorMessage);
				response.sendRedirect("signup.jsp");
			}

			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User not registered");
			e.printStackTrace();
		}
	}
}
