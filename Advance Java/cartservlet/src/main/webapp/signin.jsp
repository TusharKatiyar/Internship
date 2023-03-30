<%@page import="com.tushar.model.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User user = (User) request.getSession().getAttribute("user");
	if(user != null){
		request.setAttribute("user", user);
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html>
<html lang ="en">
    <head>
        <title>Patternfly Login</title>
        <link rel="icon" type="image/x-icon"" href="src/loginPage/icon.svg">
        <link rel="stylesheet" href="css/loginPage/style.css">
    </head>
    <body>
        <div class="mainContainer">
            <div class="formTitle">
                <div class="titleLogo">
                    <img src="src/loginPage/icon.svg" alt="Patternfly icon">
                </div>
                <div class="titleName">
                    <h1>PATTERNFLY</h1>
                </div>
            </div>
            <div class="formPara">
                <p>This is placeholder text, only. Use this area to place any information or introductory message about your application that may be relevant for users</p>
            </div>
            <div class="formContainer">
                <form id="loginForm" action="signin" method="post">
                    <div class="langContainer">
                        <select class="selectLang" name="lang" id="lang">
                            <option value="english">English</option>
                            <option value="hindi">Hindi</option>
                        </select>
                    </div>

                    <h2 class="formHeadingsContainer"> Log In to Your Account </h2>
                    <div class="formMainContainer">
                        <input autofocus id="email" type="email" name="email" placeholder="Email or phone or username" required>
                        <br><br>
                        <input id="password" type="password" name="password" placeholder="Password" required>
                        
                        <div class="subFormMainContainer">
                            <label for="keepmelogged">
                                <input type="checkbox" name="keepmelogged">Keep me logged in for 30 days
                            </label>
                            <p class="forgotPass">
                                <a href="#">Forgot password?</a>
                            </p>                                
                        </div>
                        <button type="submit">Log In</button>
                        <p class="register">
                            Need an account?
                            <a href="signup.jsp">Sign up</a>
                        </p>
                    </div>
                </form>
            </div>
            <div class="footerContainer">
                <h4>
                    <a href="#">Terms of Use</a> .
                    <a href="#">Help</a> .
                    <a href="#">Privacy Policy</a>
                </h4>
            </div>
        </div>
    </body>
</html>