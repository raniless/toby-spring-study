<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Controller Method Parameter Test</title>
</head>
<body>
    <div>
        <h2>ModelAttribute Method</h2>
        <tr><td>${modelTest}</td></tr>
        <tr>${modelTest2}</tr>
        <c:forEach var="code" items="${codes}">
            <tr>${code}</tr>
        </c:forEach>
	</div>
</body>
</html>