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

<form:form action="${pageContext.request.contextPath}/emp" method="post" enctype="application/x-www-form-urlencoded" modelAttribute="employee">

    <c:if test="${employee.id == null}">
        LastName: <form:input path="lastName" />
    </c:if>

    <c:if test="${employee.id != null}">
        <form:hidden path="id" />

        <%--对于 _method 不能使用 form: 前缀的标签， 因为 ModelAttribute里面没有这个属性，所以要使用普通的 input标签--%>

        <%--<input type="hidden" name="_method" value="put" />--%>
    </c:if>

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
