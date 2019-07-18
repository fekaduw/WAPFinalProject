<%@ page import="java.io.OutputStream" %><%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-13
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to Smart Shopping</title>
    <link href="resources/css/styles.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/scripts.js" rel="script"></script>
    <script src="https://kit.fontawesome.com/8e1265fd78.js"></script>
</head>
<body>

<div class="main-container">
    <div class="top-container">
        <div class="company-name">
            <h1>Smart Shopping</h1>
            <h2>Do less, accomplish more...</h2>
        </div>
        <div class="address-info">
            <h2>+1 641-8019-8117</h2>
            <p>7 Days a week from 8:30 am to 6:00 pm</p>
        </div>
    </div>
    <div class="main-content">
        <form method="post" action="checkout" id="checkoutForm">
            <div class="top-banner">
                <span class="login-info">Logged in as: <em>${email!=null ? email : 'Guest'}</em>
                    <a href=${email!=null ?"logout" : "login.jsp"}>${email!=null ?"Logout" : "Login"}</a>
                </span>
                <div class="cart-info">
                    <input type="text" class="search" name="search" id="search" />
                    <i class="fas fa-shopping-cart"></i> Cart (<span id="total-cart">0</span>)
                    <input type="hidden" id="productsOnCart" name="productsOnCart" value="list"/>
                    <input type="hidden" id="email" name="email" value="${email}"/>
                    <input type="submit" disabled id="checkout" value="Checkout"/>
                </div>
            </div>
        </form>
        <div class="product-list" id="product_list">
<%--            <c:forEach items="${products}" var="product">--%>
<%--                <div class="product" id="product">--%>
<%--                    <h1>${product.name}</h1>--%>
<%--                    <img alt="img" src="images/${product.id}"/>--%>
<%--                    <p>$${product.price}</p>--%>
<%--                    <input type="button" value="Add to cart" id="${product.id}"/>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
        </div>
    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>
