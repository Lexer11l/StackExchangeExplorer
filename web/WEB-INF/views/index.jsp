<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
  <title>Search Page</title>
</head>

<body>
<spring:form method="post" modelAttribute="query" action="sendQuery">

  Input text for search: <spring:input path="queryText"/>
  <br/>
  <spring:button>Find</spring:button>

</spring:form>

</body>

</html>