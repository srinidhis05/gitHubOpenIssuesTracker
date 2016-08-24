<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: srinidhis
  Date: 24/08/16
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invalid URL</title>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Github Open Issue Tracker</a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h2>The Repo URL entered is not in the format of "https://www.github.com/{username}/{repo}"</h2>
        <h2>Please ensure it and try again</h2>
        <spring:url value="/" var="homePage" />
        <form:form method="get" modelAttribute="URL" action="${homePage}">
            <input type="submit" value="Return">
        </form:form>
    </div>
</div>

</body>
</html>