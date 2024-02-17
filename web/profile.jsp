<%@ page import="kz.bitlab.academy.entity.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="static java.util.Objects.nonNull" %>
<%@ page import="kz.bitlab.academy.entity.User" %><%--
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

        <% User user = (User) request.getAttribute("user"); %>
    <div class="d-flex flex-column text-center my-3">
        <h1>Hello, <%=user.getFullName()%></h1>
        <small class="text-body-secondary">Electronic devices with high quality and service</small>
    </div>


    <div class="">


    </div>

</div>
</body>
</html>
