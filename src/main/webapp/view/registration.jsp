<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 17.06.2017
  Time: 16:34
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
    <h1>Registration</h1>
    ${error}
    <form method="post">
        <p>Login:</p>
        <input type="text" name="login" maxlength="30"/>
        <p>Password:</p>
        <input type="password" name="password" maxlength="20"/>
        <p>Confirm Password:</p>
        <input type="password" name="password2" maxlength="20"/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
