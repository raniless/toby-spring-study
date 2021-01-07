<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>test</title>
</head>
<body>
	<form:form modelAttribute="user">
	    <p>
	        <label for="name">Name : </label>
	        <form:input path="name"/>
	        <!--
	        <input type="text" id="name" name="name" value="${user.name}" />
	        -->
	    </p>
    </form:form>
</body>
</html>