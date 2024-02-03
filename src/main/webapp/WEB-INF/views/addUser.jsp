<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html>
<head>
    <title>Add User</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/add" method="post">
        Username: <input type="text" name="username" />
        Email: <input type="email" name="email" />
        Password: <input type="password" name="password" />
        Phone: <input type="text" name="phone" />
        Address: <input type="text" name="address" />
        Sex: <input type="text" name="sex" />
        Birth: <input type="text" name="birthday" />
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
