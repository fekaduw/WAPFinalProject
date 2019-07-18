<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-14
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Smart Shopping - log in</title>
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/signup.css" rel="stylesheet"/>
</head>
<body>
<div class="main-signup-container">
    <div class="company-name">
        <h1>Smart Shopping</h1>
        <h2>Do less, accomplish more...</h2>
    </div>
    <div class="sign-in-up-form">
        <form action="registerCustomer" method="post">
            <div class="sign-in">
                <div><h1>Create account</h1></div>
                <div><input type="text" name="firstName" placeholder="First name" required /></div>
                <div><input type="text" name="lastName" placeholder="Last name" required /></div>
                <div><input type="text" name="email" placeholder="Email address" required/></div>
                <div><input type="password" name="password" placeholder="Password (at least 6 characters)" pattern="\w{6,}" required/></div>
                <div><input type="text" name="state" placeholder="State" required/></div>
                <div><input type="text" name="city" placeholder="City" required/></div>
                <div><textarea name="address" placeholder="Primary address" required></textarea></div>
                <div><input type="submit" value="Create your Smart Shopping account"/></div>
            </div>
            <div class="condition">
                <p>By creating an account, you agree to Smart Shopping's Conditions of Use and Privacy Notice.</p>
            </div>
            <div class="sign-in">
                <hr>
                <p>Already have an account? <a href="login.jsp">Sign-In</a></p>
            </div>
    </div>
    </form>
</div>
</body>
</html>
