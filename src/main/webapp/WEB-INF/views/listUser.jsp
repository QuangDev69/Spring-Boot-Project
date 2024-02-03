<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<spring:url value="/css/listUser.css" var="listUserCss" />
<link href="${listUserCss}" rel="stylesheet" />

<title>Users List</title>
</head>
<body>
	<h2>Users List</h2>
	<form action="<c:url value='/auth/logout'/>" method="post">
    <input type="submit" value="Logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.userId}" /></td>
				<td><c:out value="${user.username}" /></td>
				<td><c:out value="${user.email}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
