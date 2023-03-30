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

@WebServlet("/cart-checkout")
public class CartCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			User user = (User) request.getSession().getAttribute("user");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			if(user != null) {
				ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cartList");
				if(cartList != null) {
					for(Cart cart : cartList) {
						Order order = new Order();
						order.setCourseID(cart.getCourseID());
						order.setQunatity(cart.getQuantity());
						order.setUserId(user.getEmployeeID());
						order.setDate(dateFormat.format(date));
						
						OrderDBObj orderDBObj = new OrderDBObj(DBConnection.getConnection());
						boolean flag = orderDBObj.insertOrder(order);
						
						if(!flag) {
							out.println("Order Failed to Insert");
						}
					}
					cartList.clear();
					response.sendRedirect("orders.jsp");
				}
				else {
					System.out.println("Cart Empty");
					response.sendRedirect("courses.jsp");
				}
			} else {
				response.sendRedirect("signin.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
