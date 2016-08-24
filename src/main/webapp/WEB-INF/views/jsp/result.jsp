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
    <title>Results</title> <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
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
    <h3>The open issues details for the repo ${repoURL}</h3>
    </div>
    <div class="container">
        <table class="table table-condensed">
            <tbody>
            <tr>
                <td>Total Open Issues:</td>
                <td>${totalIssues}</td>
            </tr>
            <tr>
                <td>Issues in Last 24 hrs:</td>
                <td>${dayIssuesCount}</td>
            </tr>
            <tr>
                <td>Issues opened more than 24 hours ago but less than 7 days ago:</td>
                <td>${weekIssuesCount}</td>
            </tr><tr>
                <td>Issues opened more than 7 days ago :</td>
                <td>${longtermIssuesCount}</td>
            </tr>
            </tbody>
        </table>
    </div>
    </div>
    <div class="container">
        <h2>Wanna check for other repository ??? go back</h2>
        <spring:url value="/" var="homePage" />
        <form:form method="get" modelAttribute="URL" action="${homePage}">
            <input type="submit" value="Return">
        </form:form>
    </div>
</body>
</html>
