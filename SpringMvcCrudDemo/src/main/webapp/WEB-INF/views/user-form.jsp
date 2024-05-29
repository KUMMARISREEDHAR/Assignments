<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>User Form</h2>
    <form action="${pageContext.request.contextPath}/user/save" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <label>Name:</label>
        <input type="text" name="name" value="${user.name}"/><br/>
        <label>Email:</label>
        <input type="email" name="email" value="${user.email}"/><br/>
        <button type="submit">Save</button>
    </form>
    <a href="${pageContext.request.contextPath}/user/list">Back to List</a>
</body>
</html>
