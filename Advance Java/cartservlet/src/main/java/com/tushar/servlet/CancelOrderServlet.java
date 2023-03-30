package com.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tushar.connection.DBConnection;
import com.tushar.dbobj.OrderDBObj;
import com.tushar.model.User;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			User user = (User) request.getSession().getAttribute("user");
			if(user != null) {
				String id = request.getParameter("orderid");
				if(id != null) {
					OrderDBObj orderDBObj = new OrderDBObj(DBConnection.getConnection());
					orderDBObj.cancelOrder(Integer.parseInt(id));
				}
				
				response.sendRedirect("orders.jsp");
			} else {
				response.sendRedirect("signin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
