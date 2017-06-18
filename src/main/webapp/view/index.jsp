<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 15.06.2017
  Time: 23:23
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
    <h1>Forum</h1>
    <table>
        <tr>
            <th>Topic</th>
            <th>Date</th>
            <th>Author</th>
        </tr>
        <c:forEach var="topic" items="${topics}">
            <tr>
                <td>
                    <c:url var="url" scope="page" value="/topic">
                        <c:param name="id" value="${topic.id}"/>
                    </c:url>
                    <a href="${url}">${topic.title}</a>
                </td>
                <td><fmt:formatDate value="${topic.dateTopic}" dateStyle="short" timeStyle="short" type="both"/></td>
                <td>${topic.user.login}</td>
            </tr>
        </c:forEach>
    </table>
    <c:url var="urlnewtopic" value="/newtopic" scope="page"/>
    <form action="${urlnewtopic}">
        <input type="submit" value="New Topic"/>
    </form>
    <a href="logout">Log out</a>
</body>
</html>
