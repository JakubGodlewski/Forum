<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 17.06.2017
  Time: 22:58
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
    <form method="post" action="/newtopic">
        <p>Set title:</p>
        <input type="text" name="title" maxlength="256"/>
        <p>Set contnent:</p>
        <textarea name="content" colls="40" rows ="9"></textarea><br/>
        <input type="submit" value="Add"/>
    </form>
</body>
</html>
