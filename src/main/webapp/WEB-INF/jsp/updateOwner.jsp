<%--
  Created by IntelliJ IDEA.
  User: mharikmert
  Date: 9.10.2020
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="form" uri ="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--@elvariable id="owner" type="petclinic"--%>
    <form:form modelAttribute = "owner" method = "post">
        First name: <form:input path = "firstName"/><br>
        Last name : <form:input path = "lastName"/> <br>
        <form:button name = "submit"> update owner </form:button>
    </form:form>
</body>
</html>
