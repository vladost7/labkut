<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <form:form action="${pageContext.request.contextPath}/postAdminChange" method="POST" modelAttribute="postForm">
        <h2>Редактирование комментария</h2>
        <div>
            <form:hidden path="id" placeholder="id"
                        autofocus="true"></form:hidden>
            <form:input type="text" path="title" placeholder="Заголовок комментария"
                        autofocus="true"></form:input>
        </div>
        <div>
            <form:input type="text" path="content" placeholder="Текст комментария"></form:input>
        </div>
        <div>
            <form:input type="text" path="postUser.username" placeholder="Введите имя комментатора"></form:input>
        </div>
        <button type="submit">Изменить</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>