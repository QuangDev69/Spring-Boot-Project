<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
</head>
<body>
    <h2>Đăng ký</h2>

    <form action="<c:url value='/auth/register'/>" method="post" modelAttribute="userDto">
        <label for="username">Tên người dùng:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="confirm">Xác nhận mật khẩu:</label>
        <input type="password" id="confirm" name="confirm" required><br><br>

        <input type="submit" value="Đăng ký">
    </form>
</body>
</html>
