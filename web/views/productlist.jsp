<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-15
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to Smart Shopping</title>
    <link href="../resources/css/styles.css" rel="stylesheet"/>
    <link href="../resources/css/productlist.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="../resources/js/scripts.js" rel="script"></script>
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
            <h1>Product list</h1>
        </div>
    </div>
    <div class="main-content">
        <div class="product-list">
            <div class="productslist">
                <h1 class="heading">Id</h1>
                <h1 class="heading">Name</h1>
                <h1 class="heading">Price</h1>
                <h1 class="heading">Description</h1>
                <h1 class="heading">Picture</h1>

                <c:forEach items="${products}" var="product">
                    <h1>${product.id}</h1>
                    <h1>${product.name}</h1>
                    <h1>${product.price}</h1>
                    <h1>${product.description}</h1>
                    <img alt="img" src="images/${product.id}"/>
                </c:forEach>

            </div>
        </div>
        <div class="footer">

        </div>
    </div>
</body>
</html>
