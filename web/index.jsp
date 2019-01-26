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
  </body>
</html>
