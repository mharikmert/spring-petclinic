<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix ="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content = "text/html; charset = utf-8">
    <title> create new owner</title>
</head>
<body>
    <form:form modelAttribute = "owner" method = "post">
        First name: <form:input path = "firstName"/>
        <form:errors path="firstName" cssStyle = "color:red"/><br>
        Last name : <form:input path = "lastName"/>
        <form:errors path ="lastName" cssStyle="color: red"/><br>
        <form:button name = "submit"> create owner </form:button>
    </form:form>
</body>
</html>
