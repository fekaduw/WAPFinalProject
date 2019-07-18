<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-15
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Smart Shopping - log in</title>
    <link href="resources/css/styles.css" rel="stylesheet"/>
    <link href="resources/css/login.css" rel="stylesheet"/>
    <link href="resources/css/signup.css" rel="stylesheet"/>
</head>
<body>
<div class="main-signup-container">
    <div class="company-name">
        <h1>Smart Shopping</h1>
        <h2>Do less, accomplish more...</h2>
    </div>
    <div class="sign-in-up-form">
        <form action="addProduct" method="post" enctype="multipart/form-data">
            <div class="sign-in">
                <div><h1>Add product</h1></div>
                <div><input type="hidden" name="message" value="${message}"/></div>
                <div><input type="text" name="name" placeholder="Product name" required/></div>
                <div><input type="text" name="price" placeholder="Product price (values > 0)" pattern="^[1-9][0-9\.]+"
                            required/></div>
                <div><input type="file" name="picture" value="Select the product picture"
                            placeholder="Upload the product picture" required/></div>
                <div><textarea name="description" placeholder="Description"></textarea></div>
                <div><input type="submit" value="Add product information"/></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>

