<%@ page import="kz.bitlab.academy.entity.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="static java.util.Objects.nonNull" %><%--
  Created by IntelliJ IDEA.
  User: Roma
  Date: 11.02.2024
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bitlab  Shop</title>
    <%@include file="bootstrap.jsp" %>
</head>
<body>
<div class="container-fluid">
    <%@include file="header.jsp" %>

    <div class="d-flex flex-column text-center my-3">
        <h1>Top 10 expensive items in BITLAB SHOP</h1>
        <small class="text-body-secondary">Electronic devices with high quality and service</small>
    </div>

    <div class="">
        <%
            List<Item> items = (List<Item>) request.getAttribute("items");

            if (nonNull(items)) {
                for (Item item : items) {
        %>
        <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
            <div class="col">
                <div class="card mb-4 rounded-3 shadow-sm">
                    <div class="card-header py-3">
                        <h4 class="my-0 fw-normal"><%=item.getName()%></h4>
                    </div>
                    <div class="card-body">
                        <h3 class="card-title text-success"><%=item.getPrice()%></h3>
                        <ul class="list-unstyled mt-3 mb-4">
                            <li><%=item.getDescription()%></li>
                        </ul>
                        <button type="button" class="w-100 btn btn-success">Buy now</button>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>

</div>
</body>
</html>
