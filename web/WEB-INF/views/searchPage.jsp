<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search Page</title>
</head>
<body>
<spring:form method="post" modelAttribute="query" action="queryResults">
    <h2>Search topics at StackOverflow</h2>
    <table>
        <TR>
            <TD>Text for search</TD>
            <TD><input name="intitle"> </TD>
        </TR>
        <TR>
            <TD>Page number</TD>
            <TD><input name="page"/> </TD>
        </TR>
        <TR>
            <TD>Page size (max 100)</TD>
            <TD><input name="pageSize" /> </TD>
        </TR>
        <TR>
            <TD>Sorting by</TD>
            <TD>
                <select name="sortBy">
                    <option value="activity">activity</option>
                    <option value="votes">votes</option>
                    <option value="creation">creation</option>
                    <option value="relevance">relevance</option>
                </select>
            </TD>
        </TR>
        <TR>
            <TD>Sorting order </TD>
            <TD>
                <select name="sortingOrder">
                    <option value="desc">desc</option>
                    <option value="asc">asc</option>
                </select>
            </TD>
        </TR>
        <TR>
            <TD>From date</TD>
            <TD><input type="date" name="fromDate"/> </TD>
        </TR>
        <TR>
            <TD>To date</TD>
            <TD> <input type="date" name="toDate"/></TD>
        </TR>
    </table>
    <button>Find</button>

</spring:form>

</body>

</html>