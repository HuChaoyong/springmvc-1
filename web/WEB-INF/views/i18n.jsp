<%--
  Created by IntelliJ IDEA.
  User: hcy
  Date: 4/27/19
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>i18n Test</title>
</head>
<body>
<br>
<fmt:message key="i18n.user"></fmt:message>
<br>
<a href="i18n2">I18n2 Page</a>
<br>
<br>
<a href="i18n?locale=zh_CN">中文</a>
<br>
<br>
<a href="i18n?locale=en_US">英文</a>
</body>
</html>
