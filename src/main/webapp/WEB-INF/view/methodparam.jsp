<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Controller Method Parameter Test</title>
</head>
<body>
    <div>
        <h2>HttpRequestServlet, HttpResponseServlet</h2>
        <tr>
            Request Message : ${message}
        </tr>
	</div>

	<br/>
	<div>
        <h2>HttpSession</h2>
        <tr>
            Session Value : ${sessionScope.testSessionValue}
        </tr>
	</div>
	<div>
        <h2>@PathVariable</h2>
        <tr>
            code : ${code}
            <br/>
            id : ${id}
        </tr>
	</div>
	<div>
        <h2>@RequestParam</h2>
        <tr>
            code2 : ${code2}
            <br/>
            id2 : ${id2}
        </tr>
	</div>
	<div>
        <h2>@CookieValue</h2>
        <tr>
            JSESSIONID : ${jsessionid}
        </tr>
	</div>
	<div>
        <h2>@RequestHeader</h2>
        <tr>
            Host : ${host}
            <br/>
            Accept : ${accept}
        </tr>
	</div>
	<div>
        <h2>@ModelAttribute</h2>
        <tr>
            id : ${userSearch.id}<br/>
            name : ${userSearch.name}<br/>
            level : ${userSearch.level}<br/>
            email : ${userSearch.email}
        </tr>
	</div>
</body>
</html>