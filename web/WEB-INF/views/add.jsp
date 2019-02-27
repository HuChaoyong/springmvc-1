<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hcy
  Date: 19-2-27
  Time: 下午9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/emp" method="POST" modelAttribute="employee">

    LastName: <form:input path="lastName" />

    <br>
    Email: <form:input path="email" />
    <br>

    <%
        Map<String, String> genders = new HashMap();
        genders.put("1", "Male");
        genders.put("0", "Female");

        request.setAttribute("genders", genders);
    %>
    Gender:
    <br>
    <form:radiobuttons path="gender" items="${genders}" delimiter="<br>" />
    <br>
    Department: <form:select path="department.id" items="${departments}" itemLabel="departmentName" itemValue="id"></form:select>
    <br>
    <input type="submit" value="Submit" />

</form:form>

</body>
</html>
