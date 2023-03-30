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
User user = (User) request.getSession().getAttribute("user");

request.setAttribute("user", user);


CourseDBObj cObj = new CourseDBObj(DBConnection.getConnection());
List<Courses> courses = cObj.getAllCourses();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
List<Cart> cartCourses = null;
if (cart_list != null) {
	CourseDBObj cartDbObj = new CourseDBObj(DBConnection.getConnection());
	cartCourses = cartDbObj.getCartCourses(cart_list);
	request.setAttribute("totalItem", cartDbObj.getTotalItem());
}
%>

<html lang="en">

<head>
<%@include file="includes/head.jsp"%>
<title>Courses</title>
</head>

<body style="font-family: lato;" class="bg-white bg-opacity-25">
	<header class="sticky-top">
		<%@include file="includes/navbar.jsp"%>
	</header>
	<main>
		<div class="container">
			<div class="card-header bg-light my-3">All Products</div>
			<div class="row">
				<%
				if (!courses.isEmpty()) {
					for (Courses course : courses) {
				%>
				<div class="col-md-3">
					<div class="card w-100" style="width: 18rem;">
						<img class="card-img-top" height="150" width="225"
							src="product-image/<%=course.getImage()%>" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title"><%=course.getName()%></h5>
							<h6 class="price">
								Price: <span class="material-symbols-outlined align-middle fs-5">
									currency_rupee </span><%=course.getPrice().toString()%>
							</h6>
							<h6 class="category"><%=course.getCategory()%></h6>
							<div class="mt-3 d-flex justify-content-between">
								<a href="addtocart?courseID=<%=course.getCourseID()%>"
									class="btn btn-dark">Add to Cart</a> <a
									href="order-now?courseID=<%=course.getCourseID()%>&quantity=1"
									class="btn btn-primary">Buy Now </a>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</main>
	<%@include file="includes/footer.jsp"%>
</body>

</html>