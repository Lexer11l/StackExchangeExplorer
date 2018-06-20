<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Search results</title>
  </head>
  <body>
  <spring:form method="post" action="searchPage">

    <h2>Search results</h2>

    ${queryResult} <br>

    <button>Back to search</button>
  </spring:form>
  </body>
</html>
