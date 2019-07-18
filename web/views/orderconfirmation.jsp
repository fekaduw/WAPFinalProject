<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-16
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <link href="../resources/css/styles.css" rel="stylesheet"/>
    <link href="../resources/css/checkout.css" rel="stylesheet"/>
</head>
<body>
<div class="main-container">
    <div>
        <div class="company-name">
            <h1>Smart Shopping</h1>
            <h2>Do less, accomplish more...</h2>
        </div>
    </div>
    <div class="confimation-container">
        <h1>Confirmation!</h1>
        <p class="confimation-message">Thank you! We've received your orders. You should get a reply from us with in 24
            hrs in your email address about the status of your orders.
            Let us know in our support email <em>${initParam['supportemail']}</em>
            if you don’t receive reply within 24 hrs or your orders are misplaced when you receive them.
            Please be sure to attach your order details in your email. <h3><a href="home.jsp">Back to home</a></h3></p>
    </div>
</div>
</body>
</html>
