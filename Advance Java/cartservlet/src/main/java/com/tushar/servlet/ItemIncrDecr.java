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

@WebServlet("/item-incr-decr")
public class ItemIncrDecr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			
			String func = request.getParameter("func");
			int id = Integer.parseInt(request.getParameter("courseID"));

			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
			if(func != null && id >= 1 && cartList != null) {
				for (Cart c : cartList) {
					if (c.getCourseID() == id) {
						if(func.equals("incr"))
							c.setQuantity(c.getQuantity() + 1);
						else if(func.equals("decr") && c.getQuantity() > 1)
							c.setQuantity(c.getQuantity() - 1);
						break;
					}
				}				
				response.sendRedirect("cart.jsp");
			}
			else {
				response.sendRedirect("courses.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
