package com.tushar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tushar.model.Cart;

@WebServlet("/remove-from-cart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");

			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
			if(id != null && cartList != null) {
				for (Cart c : cartList) {
					if (c.getCourseID() == Integer.parseInt(id)) {
						cartList.remove(cartList.indexOf(c));
						break;
					}
				}				
			}
			response.sendRedirect("cart.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
