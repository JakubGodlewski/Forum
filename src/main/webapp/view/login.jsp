<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 15.06.2017
  Time: 23:52
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
    <h1>Log in</h1>
    <form method="post" action="j_security_check">
        <p>Login:</p>
        <input type="text" name="j_username"/>
        <p>Password:</p>
        <input type="password" name="j_password"/><br/>
        <input type="submit" value="login"/>
    </form>
    <a href="registration">Register</a>
</body>
</html>
