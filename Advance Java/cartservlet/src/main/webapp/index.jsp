<%@page import="java.util.List"%>
<%@page import="com.tushar.connection.DBConnection"%>
<%@page import="com.tushar.dbobj.CourseDBObj"%>
<%@page import="com.tushar.model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tushar.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
User user = null;
user = (User) request.getSession(false).getAttribute("user");

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cartList");
List<Cart> cartCourses = null;
if(cart_list != null) {
	CourseDBObj cartDbObj = new CourseDBObj(DBConnection.getConnection());
	cartCourses = cartDbObj.getCartCourses(cart_list);
	request.setAttribute("totalItem", cartDbObj.getTotalItem());
}
%>

<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="includes/head.jsp"%>
<title>Webpage</title>
</head>
<% if(user != null) { %>
<body style="font-family: lato;" class="bg-black bg-opacity-25">
	<header class="sticky-top">
		<%@include file="includes/navbar.jsp"%>
	</header>
	<main>
		<div class="container-fluid">
			<div class="row">
				<!-- profile -->
				<div class="col-lg-3 col-md-4 col-sm-5 ps-2 pt-2">

					<div class="bg-white">
						<!-- edit-profile -->
						<div class="row justify-content-end p-0 me-3">
							<!-- Button trigger modal -->
							<button id="edit-button" type="button" class="btn col-2"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								<span class="material-symbols-outlined"> edit_square </span>
							</button>

							<!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<h4 class="modal-title">Your details</h4>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<form action="update-profile" method="post" enctype="multipart/form-data" id="edit-profile-form">
												<div class="row">
													<div class="col">
														<div class="row">
															<div class="col">
																<label for="nameModal">Name :</label> <input required
																	type="text" class="form-control" id="nameModal" name="nameModal"
																	value="<%= user.getFirstName() + " " + user.getLastName() %>">
															</div>
														</div>
														<div class="row">
															<div class="col">
																<label for="desgModal">Designation :</label> <input
																	required type="text" class="form-control"
																	id="desgModal" name="desgModal" value="<%= user.getDesignation() %>">
															</div>
														</div>
													</div>
													<div class="col">
														<img id="profilePicdummy"
															src="data:image/png;base64,<%= user.getProfilePicture() %>"
															class="rounded-circle"
															style="width: 120px; height: 120px;" alt="Profile Pic">
													</div>
												</div>
												<div class="row">
													<div class="row">
														<div class="col">
															<label for="addModal">Address :</label> <input required
																type="text" class="form-control" id="addModal" name="addModal"
																value="<%= user.getAddress() %>">
														</div>
													</div>
													<div class="row">
														<div class="col">
															<label for="contModal">Contact Number :</label> <input
																required type="number" class="form-control"
																id="contModal" name="contModal" value="<%= user.getContactNumber() %>">
														</div>
														<div class="col">
															<label for="emailModal">Email :</label> <input required
																type="email" class="form-control" id="emailModal" name="emailModal"
																value="<%= user.getEmail() %>">
														</div>
													</div>
													<div class="row">
														<div class="col">
															<label for="linkModal">Link :</label> <input required
																type="text" class="form-control" id="linkModal" name="linkModal"
																value="<%= user.getLink() %>">
														</div>
														<div class="col">
															<label for="langModal">Language :</label> <select
																required class="form-select fs-6 mb-2 fst-italic"
																id="langModal" name="langModal">
																<option value="">None</option>
																<option value="English">English</option>
																<option value="Hindi">Hindi</option>
															</select>
														</div>
													</div>
													<div class="row">
														<label for="profModal">Profile Picture :</label> <input
															type="file" class="form-control" id="profModal" name="profModal"
															placeholder="Choose file" style="border: none;">
													</div>
												</div>
												<div class="row justify-content-end pe-5">
													<div class="col-1">
														<input id="save-profile" type="submit"
															class="btn border-2 border-dark" value="Save">
													</div>
												</div>
											</form>
										</div>
										<div class="modal-footer"></div>
									</div>
								</div>
							</div>
						</div>


						<!-- profile-picture -->
						<div class="row person-image justify-content-center">
							<div class="col-lg-6 col-md-4 col-sm-3 col-6">
								<img id="img-thumbnail"
									src="data:image/png;base64,<%= user.getProfilePicture() %>"
									class="img-thumbnail rounded-circle border-0" alt="" />
							</div>
						</div>
						<div class="row">
							<h3 id="fullName" class="fullName text-center fw-bold">
								<%= user.getFirstName() + " " + user.getLastName() %></h3>
						</div>
						<div class="row">
							<p id="designation" class="designation text-center">
								<%= user.getDesignation() %></p>
						</div>
						<div class="row justify-content-center">
							<div class="col-11">
								<hr>
							</div>
						</div>
						<div class="row ps-3 pe-2 fs-6">
							<ul class="list-unstyled">
								<li class="address">
									<div class="row">
										<div class="col-1">
											<span class="material-symbols-outlined"> location_on </span>
										</div>
										<div class="col-11">
											<small id="address"><%= user.getAddress() %></small>
										</div>
									</div>
								</li>
								<li class="contactNumber">
									<div class="row">
										<div class="col-1">
											<span class="material-symbols-outlined"> call </span>
										</div>
										<div class="col-11">
											<small id="contactNumber"><%= user.getContactNumber() %></small>
										</div>
									</div>
								</li>

								<li class="email">
									<div class="row">
										<div class="col-1">
											<span class="material-symbols-outlined"> email </span>
										</div>
										<div class="col-11">
											<p>
												<a id="email" href="<%= user.getEmail() %>"><%= user.getEmail() %></a>
											</p>
										</div>
									</div>
								</li>

								<li class="link">
									<div class="row">
										<div class="col-1">
											<span class="material-symbols-outlined"> link </span>
										</div>
										<div class="col-11">
											<a id="link"
												href="<%= user.getLink() %>"><%= user.getLink() %></a>
										</div>
									</div>
								</li>

								<li class="language">
									<div class="row">
										<div class="col-1">
											<span class="material-symbols-outlined"> language </span>
										</div>
										<div class="col-11">
											<small id="language"><%= user.getLanguage() %></small>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="row justify-content-center">
							<div class="col-11">
								<hr>
							</div>
						</div>
						<div class="row justify-content-center">
							<div class="col-2 pb-0 ps-2">
								<img class="pb-0" style="height: 40px; width: 40px;"
									src="src/webPage/twitter_icon.png" alt="twitter">
							</div>
							<div class="col-1 ps-0">
								<img class="" style="height: 50px; width: 50px;"
									src="src/webPage/cloud.svg" alt="cloud">
							</div>
						</div>
					</div>
				</div>
				<!-- background -->
				<div class="col-lg-9 col-md-8 col-sm-7 ps-0 pt-2 pe-2">
					<div class="background bg-white p-2">
						<h5>BACKGROUND</h5>
						<hr>

						<div class="background-content">
							<!-- about -->
							<div class="row">
								<div style="width: 4%;" class="about-logo">
									<span class="material-symbols-outlined fs-5 ps-2 pt-1">
										badge </span>
								</div>
								<div style="width: 96%;" class="about-content">
									<h5 class="mb-1">
										<small class="mb-0"> ABOUT </small>
									</h5>
									<hr class="m-0 p-0">
									<p class="mt-1 mb-2 fs-6">
										<small>Lorem ipsum dolor sit amet, consectetur
											adipiscing elit, sed do eiusmod tempor incididunt ut labore
											et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
											exercitation ullamco laboris nisi ut aliquip ex ea commodo
											consequat. Duis aute irure dolor in reprehenderit in
											voluptate velit esse cillum dolore eu fugiat nulla pariatur.
											Excepteur sint occaecat cupidatat non proident, sunt in culpa
											qui officia deserunt mollit anim id est laborum. </small>
									</p>
								</div>
							</div>
							<!-- work experience -->
							<div class="row">
								<div style="width: 4%;" class="about-logo">
									<span class="material-symbols-outlined fs-5 ps-2 pt-1">
										work </span>
								</div>
								<div style="width: 96%;" class="about-content">
									<h5 class="mb-1">
										<small class="mb-0"> WORK EXPERIENCE </small>
									</h5>
									<hr class="m-0 p-0">
									<p class="mb-0">
										<span class="fw-bold fs-6">Project 1</span> <small><span
											class="text-primary">, Java</span></small> <small><span
											class="text-primary">, Angular</span></small>
									</p>
									<p class="fs-6 mb-1 align-self-center text-muted">
										<small> Dec,2013 - Dec,2014 <span
											class="t material-symbols-outlined fs-6 pt"> schedule
										</span> 1 Year
										</small>
									</p>
									<p class="mt-1 mb-2 fs-6 line-s">
										<small>Lorem ipsum dolor sit amet, consectetur
											adipiscing elit, sed do eiusmod tempor incididunt ut labore
											et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
											exercitation ullamco laboris nisi ut aliquip ex ea commodo
											consequat. Duis aute irure dolor in reprehenderit in
											voluptate velit esse cillum dolore eu fugiat nulla pariatur.
											Excepteur sint occaecat cupidatat non proident, sunt in culpa
											qui officia deserunt mollit anim id est laborum. </small>
									<ul class="mb-0">
										<li><small> Random Point 1 </li>
										</small>
										<li><small> Random Point 2 </li>
										</small>
										<li><small> Random Point 3 </li>
										</small>
									</ul>
									</p>
								</div>
							</div>
							<!-- Skill -->
							<div class="row mb-2">
								<div style="width: 4%;" class="skill-logo">
									<span class="material-symbols-outlined fs-5 ps-2 pt-1">
										construction </span>
								</div>
								<div style="width: 96%;" class="skill-content">
									<h5 class="mb-1">
										<small class="mb-0"> SKILL </small>
									</h5>
									<hr class="m-0 p-0">
									<div class="row">
										<!-- skill-1 -->
										<div
											class="ms-3 col-11 skill-content border-start border-5 border-success ps-1">
											<h5 class="mb-1">
												<small class="mb-0"> Web Development </small>
											</h5>
											<span class="bg-primary p-1 rounded fw ">HTML</span> <span
												class="bg-primary p-1 rounded fw">CSS</span> <span
												class="bg-primary p-1 rounded fw">JavaScript</span>
										</div>
									</div>
									<hr class="mt-1 mb-1">
									<div class="row">
										<div
											class="ms-3 col-11 skill-content border-start border-5 border-success ps-1">
											<h5 class="mb-1">
												<small class="mb-0"> Compression </small>
											</h5>
											<span class="bg-primary p-1 rounded fw">Mpeg</span> <span
												class="bg-primary p-1 rounded fw">MP4</span> <span
												class="bg-primary p-1 rounded fw">GIF</span>
										</div>
									</div>
								</div>
							</div>
							<!-- education -->
							<div class="row">
								<div style="width: 4%;" class="education-logo">
									<span class="material-symbols-outlined fs-5 ps-2 pt-1">
										school </span>
								</div>
								<div style="width: 96%;" class="education-content">
									<h5 class="mb-1">
										<small class="mb-0"> EDUCATION </small>
									</h5>
									<hr class="m-0 p-0">
									<p class="mb-0">
										<span class="fw-bold fs-6"> Bachelor of Technology</span> <small><span
											class="text-primary">, IIIT Bhagalpur</span></small>
									</p>
									<p class="fs-6 mb-1 align-self-center text-muted">
										<small> Jun,2019 - Jan,2023 </small>
									</p>
									<p class="fs-6 mb-1 pt-">
										<small> CGPA:Random </small>
									</p>
									<div class="row">
										<!-- Subjects -->
										<div style="width: 100%;" class="skill-content ps-3">
											<span class="bg-primary p-1 rounded fw">DB101-Basic
												SQL</span> <span class="bg-primary p-1 rounded fw">CS201-Java
												Introduction</span>
										</div>
									</div>
								</div>
							</div>
							<!-- interests -->
							<div class="row">
								<div style="width: 4%;" class="about-logo">
									<span class="material-symbols-outlined fs-5 ps-2 pt-1">
										favorite </span>
								</div>
								<div style="width: 96%;" class="about-content">
									<h5 class="mb-1">
										<small class="mb-0"> INTERESTS </small>
									</h5>
									<hr class="m-0 p-0">
									<div class="row">
										<!-- interest-1 -->
										<div style="width: 100%;" class="skill-content ps-3">
											<h5 class="mb-1">
												<small class="mb-0"> Wildlife </small>
											</h5>
											<span class="bg-primary p-1 rounded fw">Forrests</span>
											<span class="bg-primary p-1 rounded fw">UNicorns</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@include file="includes/footer.jsp" %>
</body>
<% } %>

</html>