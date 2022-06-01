<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>luv2code Company Home Page</title>
</head>
<body>
<h2>luv2code Company Home Page</h2>
Welcome to home page!!

<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="logout"/>
</form:form>
</body>
</html>