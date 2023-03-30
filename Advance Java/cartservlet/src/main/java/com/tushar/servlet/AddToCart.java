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

@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			ArrayList<Cart> cartList = new ArrayList<>();

			int id = Integer.parseInt(request.getParameter("courseID"));

			Cart cart = new Cart();
			cart.setCourseID(id);
			cart.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");

			if (cart_list == null) {
				cartList.add(cart);
			} else {
				cartList = cart_list;
				boolean exist = false;
				for (Cart c : cartList) {
					if (c.getCourseID() == id) {
						exist = true;
						c.setQuantity(c.getQuantity() + 1);
					}
				}
				if (!exist) {
					cartList.add(cart);
				}
			}
			session.setAttribute("cartList", cartList);
			response.sendRedirect("courses.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
