<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/user/form">Add New User</a>
</body>
</html>
