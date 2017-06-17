<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 17.06.2017
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Forum</title>
</head>
<body>
    <h1>Topic - ${topic.title}</h1>
    <table border="1">
        <tr>
            <th>Login</th>
            <th width="800">Content</th>
            <th>Date</th>
        </tr>
        <tr>
            <td>${topic.user.login}</td>
            <td>${topic.content}</td>
            <td>${topic.date}</td>
        </tr>
        <c:forEach var="inscription" items="${topic.inscriptions}">
            <tr>
                <td>${inscription.user.login}</td>
                <td>${inscription.content}</td>
                <td>${inscription.date}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="post">
        <input type="hidden" name="id" value="${topic.id}"/>
        <p>Set response content:</p>
        <textarea name="content" colls="40" rows="8"></textarea><br/>
        <input type="submit" value="OK"/>
    </form>
</body>
</html>
