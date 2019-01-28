<%--
  Created by IntelliJ IDEA.
  User: hcy
  Date: 19-1-29
  Time: 上午1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SessionAttributes Test</title>
</head>
<body>
<h2>user: ${requestScope.user}</h2>
<h2>user: ${sessionScope.user}</h2>
<br>
<br>
<br>
<h2>age: ${requestScope.age}</h2>
<h2>age: ${sessionScope.age}</h2>
</body>
</html>
