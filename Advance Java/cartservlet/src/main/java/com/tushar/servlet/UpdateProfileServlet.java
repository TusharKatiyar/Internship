package com.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Signup</title>");
			out.println("</head>");
			out.println("<body>");
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				String fullName = request.getParameter("nameModal");
				String[] name = fullName.split(" ");
				String designation = request.getParameter("desgModal");
				String contactNumber = request.getParameter("contModal");
				String email = request.getParameter("emailModal");
				String address = request.getParameter("addModal");
				Part filePart = request.getPart("profModal");
				String profilePicture = null;
				byte[] byteArray = filePart.getInputStream().readAllBytes();
				if (byteArray.length > 0) {
					profilePicture = Base64.getEncoder().encodeToString(byteArray);
				} else {
					profilePicture = user.getProfilePicture();
				}
				String link = request.getParameter("linkModal");
				String language = request.getParameter("langModal");
				UserDbObj userDbObj = new UserDbObj(DBConnection.getConnection());

				if (userDbObj.updateUser(user.getEmployeeID(), name[0], name[1], designation, address, contactNumber,
						email, link, language, profilePicture)) {
					// updated user profile
					user = userDbObj.getUser(user.getEmployeeID());
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					System.out.println("User Updated.");
					response.sendRedirect("index.jsp");
				} else {
					String errorMessage = "User Not updated";
					HttpSession regSession = request.getSession();
					regSession.setAttribute("RegError", errorMessage);
					response.sendRedirect("signup.jsp");
				}
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
