<%@page import="com.tushar.dbobj.OrderDBObj"%>
<%@page import="com.tushar.model.Order"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tushar.connection.DBConnection"%>
<%@page import="java.util.List"%>
<%@page import="com.tushar.dbobj.CourseDBObj"%>
<%@page import="com.tushar.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tushar.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
List<Order> orders = null;
User user = (User) request.getSession().getAttribute("user");

request.setAttribute("user", user);
OrderDBObj orderDBObj = new OrderDBObj(DBConnection.getConnection());
orders = orderDBObj.userOrders(user.getEmployeeID());

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
List<Cart> cartCourses = null;
if (cart_list != null) {
	CourseDBObj cartDbObj = new CourseDBObj(DBConnection.getConnection());
	cartCourses = cartDbObj.getCartCourses(cart_list);
	request.setAttribute("totalItem", cartDbObj.getTotalItem());
}
%>
<html>
<head>
<%@include file="includes/head.jsp"%>
<title>Courses</title>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>

				<%
				if (orders != null) {
					for (Order order : orders) {
				%>
				<tr>
					<td><%=order.getDate()%></td>
					<td><%=order.getName()%></td>
					<td><%=order.getCategory()%></td>
					<td><%=order.getQunatity()%></td>
					<td><%=dcf.format(order.getPrice())%></td>
					<td><a class="btn btn-sm btn-danger"
						href="cancel-order?orderid=<%=order.getOrderId()%>">Cancel Order</a></td>
				</tr>
				<%
				}
				}
				%>

			</tbody>
		</table>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>