<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Users List</title>
    <link href="<c:url value='/css/listUser.css'/>" rel="stylesheet" />
    <style>
    	.pagination {
    		display:flex;
    		justify-content: center;
    		width: 100%;
    	}
    	.pagination__list {
    	 	list-style:none;
    		width: 100%;
    		display:flex;
    		justify-content: center;
    	}
    	.pagination__list li {
    	padding: 6px;
    	margin: 0 10px;
    	}
    	.pagination__list li a {
    		font-size: 20px;
    		font-weight: bold;
    		text-decoration:none;
    		color: black;
    	}
    </style>
</head>
<body>
    <h2>Users List</h2>
    <form action="<c:url value='/auth/logout'/>" method="post">
        <input type="submit" value="Logout" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${usersPage.content}">
            <tr>
                <td><c:out value="${user.userId}" /></td>
                <td><a href="<c:url value='/users/'/>${user.userId}"><c:out value="${user.username}" /></a></td>
                <td><c:out value="${user.email}" /></td>
                <td>
                    <form action="<c:url value='/users/'/>${user.userId}/delete" method="post">
                        <button type="submit">Delete</button>
                        <input type="hidden" name="userId" value="${user.userId}" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

	<div class="pagination">
	    <c:if test="${usersPage.totalPages >= 1}">
	        <ul class="pagination__list">
	            <li class="${usersPage.first ? 'disabled' : ''}">
	                <a href="?page=0">&laquo;</a>
	            </li>
	            <c:forEach var="i" begin="1" end="${usersPage.totalPages }">
	                <li>
	                    <a href="?page=${i- 1}">${i }</a>
	                </li>
	            </c:forEach>
	            <li class="${usersPage.last ? 'disabled' : ''}">
	                <a href="?page=${usersPage.totalPages - 1}">&raquo;</a>
	            </li>
	        </ul>
	    </c:if>
	</div>
    
    <script>
    console.log(${usersPage.totalPages});
</script>
    
</body>
</html>
