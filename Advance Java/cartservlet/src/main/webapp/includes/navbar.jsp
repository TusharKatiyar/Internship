<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg p-0 navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">WebSiteName</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse align-items-center"
			id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="courses.jsp">Courses</a></li>
			</ul>
			<ul class="navbar-nav me-1 mb-lg-0">

				<li class="nav-item"><a href="cart.jsp">
						<button id="signout" type="button"
							class="bg-transparent border-0 text-white">
							<span class="material-symbols-outlined align-middle">
								shopping_cart </span> <span class="align-middle"> Cart <span
								class="badge bg-danger ms-1">${ (totalItem > 0) ? totalItem : "" }</span>
							</span>
						</button>
				</a></li>
				<%
				if (user != null) {
				%>
				<li class="nav-item"><a href="orders.jsp">
						<button id="signout" type="button"
							class="bg-transparent border-0 text-white">
							<span class="material-symbols-outlined align-middle">
								shopping_bag </span> <span class="align-middle"> Order </span>
						</button>
				</a></li>
				<li class="nav-item"><a href="signout">
						<button id="signout" type="button"
							class="bg-transparent border-0 text-white">
							<span class="material-symbols-outlined align-middle">
								person </span> <span class="align-middle"> Signout </span>
						</button>
				</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a href="signin">
						<button id="signout" type="button"
							class="bg-transparent border-0 text-white">
							<span class="material-symbols-outlined align-middle">
								login </span> <span class="align-middle"> Signin </span>
						</button>
				</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</div>
</nav>