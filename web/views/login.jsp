<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-14
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Smart Shopping - log in</title>
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet"/>
</head>
<body>
<%
    String email = "", password = "";
    Cookie[] cookies = request.getCookies();
    boolean isRemembermeChecked = false;

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("email")) {
                email = cookie.getValue();
            }

            if (cookie.getName().equals("password")) {
                password = cookie.getValue();
            }

            if (cookie.getName().equals("rememberme")) {
                isRemembermeChecked = cookie.getValue().equals("true");
            }
        }
    }
%>
<div class="main-login-container">
    <div class="company-name">
        <h1>Smart Shopping</h1>
        <h2>Do less, accomplish more...</h2>
    </div>
    <div class="sign-in-up-form">
        <form action="login" method="post">
            <input type="hidden" name="requestFrom" value="${requestFrom}" />
            <div class="sign-in">
                <div><h1>Sign-In</h1></div>
                <p class="error">${ error }</p>
                <div><input type="text" name="email" placeholder="Email address" required value="<%= email%>"/></div>
                <div><input type="password" name="password" placeholder="Password" required value="<%= password%>"/>
                </div>
                <div><input type="submit" value="Sign-In"/></div>
            </div>
            <div class="condition">
                <p>By continuing, you agree to Smart Shopping's Conditions of Use and Privacy Notice.
                    Keep me signed in. Details </p>
                <label><input type="checkbox"  <%= isRemembermeChecked ? "checked = checked" : "" %> name="rememberme"
                              value="rememberme"/>Keep me signed in</label>
            </div>
            <div class="create-account">
                <hr>
                <p>New to Smart Shopping?</p>
                <p><a href="registercustomer.jsp" id="createAccount">Create your Smart Shopping account</a></p>
            </div>
        </form>
    </div>
</div>
</body>
</html>
