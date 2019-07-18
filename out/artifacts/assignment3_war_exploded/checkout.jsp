<%--
  Created by IntelliJ IDEA.
  User: gladiator
  Date: 2019-07-14
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link href="resources/css/styles.css" rel="stylesheet"/>
    <link href="resources/css/login.css" rel="stylesheet"/>
    <link href="resources/css/checkout.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/8e1265fd78.js"></script>
    <script src="resources/js/checkout.js"></script>
</head>
<body>
<div class="main-container">
    <div class="top-container">
        <div class="company-name">
            <h1>Smart Shopping</h1>
            <h2>Do less, accomplish more...</h2>
        </div>
        <div class="address-info">
            <h1><i class="fas fa-shopping-cart"></i> Checkout item (<span id="total-cart">${fn:length(products)}</span>)
            </h1>
        </div>
    </div>
    <div class="checkout-info">
        <div class="customer-detail">
            <div class="left">
                <h3>Shipping address</h3>
                <p>
                    ${customer.address}
                </p>

                <h3>Payment method</h3>
                <p>
                    MasterCard MasterCard ending in 1234
                    Billing address: Same as shipping address.
                </p>
            </div>
            <form action="checkoutConfirmation" method="post">
                <input type="hidden" value="${productsOnCart}" name="productsOnCart" />
                <div class="order-summary">

                    <input type="submit" value="Place your order"/>

                    <h2>Order summary</h2>
                    <table>
                        <tr>
                            <td>Items:</td>
                            <td class="amount" id="total">$${totalprice}</td>
                        </tr>
                        <tr>
                            <td>Shipping and handling:</td>
                            <td class="amount" id="shipping">$10</td>
                        </tr>
                        <tr>
                            <td>Total before tax:</td>
                            <td class="amount" id="totalBeforeTax">$55.89</td>
                        </tr>
                        <tr>
                            <td>Estimated tax to be collected:</td>
                            <td class="amount" id="tax">$55.89</td>
                        </tr>
                        <tr class="order-total">
                            <td>Order total:</td>
                            <td class="amount" id="orderTotal">$55.89</td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
        <div class="right"><h3>Review items and shipping</h3>
            <div class="prodcts-in-cart-to-review">
                <c:forEach items="${products}" var="product">

                    <div class="item">
                        <img alt="img" src="images/${product.id}" alt="product ${product.id}"/>
                        <div class="item-details">
                            <h3>${product.name}</h3>
                            <select name="quantity" class="quantity" id="${product.id}">
                                <option value="1" id="${product.id}">1</option>
                                <option value="2" id="${product.id}">2</option>
                                <option value="3" id="${product.id}">3</option>
                                <option value="4" id="${product.id}">4</option>
                                <option value="5" id="${product.id}">5</option>
                                <option value="6" id="${product.id}">6</option>
                                <option value="7" id="${product.id}">7</option>
                                <option value="8" id="${product.id}">8</option>
                                <option value="9" id="${product.id}">9</option>
                                <option value="10" id="${product.id}">10</option>
                            </select>
                            <p>Unit price: <span id="p${product.id}">${product.price}</span></p>
                            <p>Sold by: ABC Technologies Inc.</p>
                            <p class="available-in">In Stock</p>
                            <label>Delivery date<input type="date" name="delivery-date"></label>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
