<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tushar.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tushar.model.Courses"%>
<%@page import="java.util.List"%>
<%@page import="com.tushar.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tushar.dbobj.CourseDBObj"%>
<%@page import="com.tushar.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

User user = (User) request.getSession().getAttribute("user");

request.setAttribute("user", user);


CourseDBObj cObj = new CourseDBObj(DBConnection.getConnection());
List<Courses> courses = cObj.getAllCourses();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
List<Cart> cartCourses = null;
if(cart_list != null) {
	CourseDBObj cartDbObj = new CourseDBObj(DBConnection.getConnection());
	cartCourses = cartDbObj.getCartCourses(cart_list);
	request.setAttribute("cartList", cart_list);
	request.setAttribute("totalPrice", cartDbObj.getTotalPrice());
	request.setAttribute("totalItem", cartDbObj.getTotalItem());
}
%>

<html>
<head>
<%@include file="includes/head.jsp"%>
<title>Course Cart</title>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="d-flex py-3">
			<h3>
				Total Price: <span class="material-symbols-outlined align-middle">currency_rupee
				</span> ${ (totalPrice > 0)? dcf.format(totalPrice) : 0 }
			</h3>
			<a class="mx-3 btn btn-primary" href="cart-checkout">Check Out</a>
		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					<th class="col">Name</th>
					<th class="col">Category</th>
					<th class="col-2">Price</th>
					<th class="col-3">Quantity</th>
					<th class="col-1">Buy Now</th>
					<th class="col-1">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart cartItem : cartCourses) {
				%>
				<tr>
					<td><%= cartItem.getName() %></td>
					<td><%= cartItem.getCategory() %></td>
					<td><span class="material-symbols-outlined align-middle">currency_rupee
					</span><%= dcf.format(cartItem.getPrice()) %></td>
					<td>
						<form action="order-now" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%= cartItem.getCourseID() %>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn btn-sm btn-decre" href="item-incr-decr?func=decr&courseID=<%= cartItem.getCourseID() %>"><i
									class="fas fa-minus-square"></i></a> <input type="text"
									name="quantity" class="form-control" value="<%= cartItem.getQuantity() %>" readonly>
								<a class="btn btn-sm btn-incre" href="item-incr-decr?func=incr&courseID=<%= cartItem.getCourseID() %>"><i
									class="fas fa-plus-square"></i></a>
							</div>
						</form>
					</td>
					<td>
						<a class="btn btn-primary btn-sm" href="order-now?courseID=<%= cartItem.getCourseID() %>&quantity=<%= cartItem.getQuantity() %>">Buy</a>
					</td>
					<td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%= cartItem.getCourseID() %>">Remove</a></td>
					</tr>
					<% }      
					}%>
			</tbody>
		</table>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>