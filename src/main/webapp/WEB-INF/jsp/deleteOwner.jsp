<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix ="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content = "text/html; charset = utf-8">
    <title> delete new owner</title>
</head>
<body>
<form:form modelAttribute = "owner" method = "post">
    First name: <form:input path = "firstName"/><br>
    Last name : <form:input path = "lastName"/> <br>
    <form:button name = "submit"> delete owner </form:button>
</form:form>
</body>
</html>
