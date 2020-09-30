<!DOCTYPE html>
<html xmlns:th = "https://www.thymeleaf.org" lang="">
<head>
    <link th:href = "@{/public/css/style.css}" type = "text/css" rel ="stylesheet"/>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
    <h1> index page </h1>
        <from action = "logout" method = "POST">
            <input type = "submit" value = "logout"/>
            <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"/>
        </from>
</body>
</html>