package com.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tushar.connection.DBConnection;
import com.tushar.dbobj.OrderDBObj;
import com.tushar.model.Cart;
import com.tushar.model.Order;
import com.tushar.model.User;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
		
			User user = (User)request.getSession().getAttribute("user");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if(user != null) {
				String courseID = (String) request.getParameter("courseID");
				String quantity = (String) request.getParameter("quantity");
				
				Order order = new Order();
				if(courseID != null && quantity != null) {
					order.setCourseID(Integer.parseInt(courseID));
					order.setQunatity(Integer.parseInt(quantity));
					order.setUserId(user.getEmployeeID());
					order.setDate(dateFormat.format(date));
					OrderDBObj orderDBObj = new OrderDBObj(DBConnection.getConnection());
					boolean flag = orderDBObj.insertOrder(order);
					
					if(flag) {
						ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cartList");
						if (cartList != null) {
							for(Cart cart : cartList) {
								if(cart.getCourseID() == Integer.parseInt(courseID)) {
									cartList.remove(cartList.indexOf(cart));
									break;
								}
							}
						}
						response.sendRedirect("orders.jsp");
					}
					else {
						out.println("order failed");
					}
				}
			}
			else {
				response.sendRedirect("signin.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
