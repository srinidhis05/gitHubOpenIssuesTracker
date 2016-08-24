<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: srinidhis
  Date: 21/08/16
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IssueTracker</title>
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
    <h2>Welcome</h2>
    </div>
    </div>

<div class="container">
    <h3>Enter the Github URL</h3>
<spring:url value="/getResults" var="viewResults" />
<form:form method="post" modelAttribute="URL" action="${viewResults}">
    <form:input path="URLLink" type="text" size="150" />
    <input type="submit" value="Submit" size="50">
</form:form>
        </div>
</body>
</html>
