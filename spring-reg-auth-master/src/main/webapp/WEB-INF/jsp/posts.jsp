<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>

        </thead>
        <c:forEach items='${allPosts}' var="post">
            <table style="border: hidden; margin: auto; ">
                <tr style="border: hidden; text-align: center;">
                    <th>Тема: ${post.title}</th>
                </tr>
                <tr style="border: hidden; text-align: center;">
                    <td>${post.content}</td>
                </tr>

                <tr style="border: hidden; text-align: center;">
                    <td>Автор: ${post.postUser.username}</td>
                </tr>
            </table>

        </c:forEach>
    </table>

    <a href="/">Главная</a>
</div>
</body>
</html>