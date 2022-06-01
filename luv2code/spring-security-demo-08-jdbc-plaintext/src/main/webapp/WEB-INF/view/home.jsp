<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>luv2code Company Home Page</title>
</head>
<body>
<h2>luv2code Company Home Page</h2>
Welcome to home page!!
<hr>

<p>
User: <security:authentication property="principal.username"/>
<br><br>
Role(s): <security:authentication property="principal.authorities"/>
</p>

<hr>
<security:authorize access="hasRole('MANAGER')">
<p>
<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
<i>(Only for managers)</i>
</p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<p>
<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
<i>(Only for admins)</i>
</p>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="logout"/>
</form:form>
</body>
</html>