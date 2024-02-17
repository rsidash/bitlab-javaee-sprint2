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

    <%
        if (request.getParameter("loginFailed") != null) {
    %>
    <div class="alert alert-danger" role="alert">
        Login failed
    </div>
    <%
        }
    %>

    <form class="container mt-3" action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3 row">
            <label for="email" class="col-sm-2 col-form-label">Email address</label>
            <div class="col-sm-10">
                <input type="email" name="email" class="form-control" id="email" placeholder="name@example.com">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="password">
            </div>
        </div>

        <button type="submit" class="btn btn-success">Login</button>
    </form>

</div>
</body>
</html>
