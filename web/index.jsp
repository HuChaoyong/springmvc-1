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
  <script src="script/jquery.min.js"></script>
  <script>
      $(function () {
          $("#testJson").click(function () {
              var url = this.href;
              var args = {};
              $.post(url, args, function (data) {
                  console.log(data);
              });
              return false;
          });
      })
  </script>
  <body>


  <a href="/emps">List all Employees!</a>
  <br>
  <br>
  <a href="/testJson" id="testJson">Get Json</a>

  </body>
</html>
