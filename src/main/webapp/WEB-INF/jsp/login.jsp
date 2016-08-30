<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<body>
<h2>NOTES Mkhimich</h2>

<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <c:if test="${not empty error}">
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${not empty msg}">
        <div>
            You have been logged out.
        </div>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>
<a href="/notes/register">Sign In</a>
</body>
</html>
<%--<!DOCTYPE html>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title></title>--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/social-buttons-3.css"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="page-header">--%>
    <%--<h1>Mkhimich Notes</h1>--%>
<%--</div>--%>
<%--<!----%>
    <%--If the user is anonymous (not logged in), show the login form--%>
    <%--and social sign in buttons.--%>
<%---->--%>
<%--<sec:authorize access="isAnonymous()">--%>
    <%--<!-- Login form -->--%>
    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-body">--%>
            <%--<h2>Login</h2>--%>
            <%--<!----%>
                <%--Error message is shown if login fails.--%>
            <%---->--%>
            <%--<c:if test="${param.error eq 'bad_credentials'}">--%>
                <%--<div class="alert alert-danger alert-dismissable">--%>
                    <%--<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>--%>
                    <%--<p>Bad Credentials</p>--%>
                <%--</div>--%>
            <%--</c:if>--%>
            <%--<!-- Specifies action and HTTP method -->--%>
            <%--<c:url value="/login" var="loginUrl"/>--%>
            <%--<form action="${loginUrl}" method="post">--%>
                <%--<!-- Add CSRF token -->--%>
                <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                <%--<div class="row">--%>
                    <%--<div id="form-group-email" class="form-group col-lg-4">--%>
                        <%--<label class="control-label" for="user-email">email:</label>--%>
                        <%--<!-- Add username field to the login form -->--%>
                        <%--<input id="user-email" name="username" type="text" class="form-control"/>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <%--<div class="row">--%>
                    <%--<div id="form-group-password" class="form-group col-lg-4">--%>
                        <%--<label class="control-label" for="user-password">password:</label>--%>
                        <%--<!-- Add password field to the login form -->--%>
                        <%--<input id="user-password" name="password" type="password" class="form-control"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="row">--%>
                    <%--<div class="form-group col-lg-4">--%>
                        <%--<!-- Add submit button -->--%>
                        <%--<button type="submit" class="btn btn-default">Login</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
            <%--<div class="row">--%>
                <%--<div class="form-group col-lg-4">--%>
                    <%--<!-- Add create user account link -->--%>
                    <%--<a href="${pageContext.request.contextPath}/user/register">Register</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- Social Sign In Buttons -->--%>
    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-body">--%>
            <%--<h2>Sign In with Social Media</h2>--%>
            <%--<div class="row social-button-row">--%>
                <%--<div class="col-lg-4">--%>
                    <%--<!-- Add Facebook sign in button -->--%>
                    <%--<a href="${pageContext.request.contextPath}/auth/googleplus"><button class="btn btn-google"><i class="icon-google"></i> Google+</button></a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</sec:authorize>--%>
<%--<!----%>
    <%--If the user is already authenticated, show a help message instead--%>
    <%--of the login form and social sign in buttons.--%>
<%---->--%>
<%--<sec:authorize access="isAuthenticated()">--%>
    <%--<p>Help</p>--%>
<%--</sec:authorize>--%>
<%--</body>--%>
<%--</html>--%>