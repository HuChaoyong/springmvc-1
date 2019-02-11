<%--
  Created by IntelliJ IDEA.
  User: hcy
  Date: 19-1-24
  Time: 下午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>23333</h2>
  <a href="/springmvc/testRequestMapping">HelloWorld!</a>
  <br>
  <a href="/springmvc/testParamsAndHeaders?username=hcy&age=11">Test ParamsAndHeaders!</a>
  <br>
  <a href="/springmvc/testAntPath/23333/abc">Test AntPath!</a>
  <br>

  <a href="/springmvc/testPathVariable/6545">Test PathVariable!</a>
  <br>

  <a href="/springmvc/testRequestParam?username=abc&age=23">Test RequestParam!</a>
  <br>

  <a href="/springmvc/testRequestHeader">Test RequestHeader!</a>
  <br>

  <a href="/springmvc/testCookieValue">Test CookieValue!</a>
  <br>

  <a href="springmvc/testServletAPI"> Test ServletAPI</a>
  <br>

  <a href="springmvc/testModelAndView"> Test ModelAndView</a>
  <br>

  <a href="springmvc/testMap"> Test Map</a>
  <br>
  <a href="springmvc/testSessionAttributes"> Test SessionAttributes</a>
  <br>

  <br>
  <br>
  <br>
  <br>

  <form action="/springmvc/testMethod" method="post">
      <input type="submit" value="submit" />
  </form>


  <form action="/springmvc/testRest/12" method="post">
      <input type="hidden" name="_method" value="DELEET">
      <input type="submit" value="DELETE" />
  </form>


  <form action="/springmvc/testRest/13" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="PUT" />
  </form>

  <br>
  <br>
  <form action="/springmvc/testPojo" method="post">
    <br>
    username:<input type="text" name="name" />
    <br>
    password:<input type="password" name="password" />
    <br>
    email:<input type="text" name="email" />
    <br>
    province:<input type="text" name="address.province" />
    <br>
    city:<input type="text" name="address.city" />
    <br>
    <input type="submit" value="Submit" />
  </form>

  <br>
  <br>

  <form action="/springmvc/testModelAttribute" method="post">
    <br>
    username <<input type="text" name="name" value="Jack">
    <br>
     <input type="hidden" name="id" value="1">
    <br>
    <input type="submit" value="submit" />
  </form>


  </body>
</html>
