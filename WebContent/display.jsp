<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>Display Information</title>
</head>
<body>
 
<sql:setDataSource var="snapshot" driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
     url="jdbc:sqlserver://127.0.0.1:56194;databaseName=birthday;instanceName=SQLEXPRESS"
     user="sgorkal"  password="infy1234"/>

<sql:query dataSource="${snapshot}" var="result">

select * from UserInfo where Email='<%=(String)session.getAttribute("emailtoAnotherPage")%>';
</sql:query>
 
<table border="1" width="100%">
<tr>
<th>Name</th>
<th>Birthday Date</th>
<th>Birthday Month</th>
<th>Birthday Year</th>
<TH>Update</TH>
<TH>Delete</TH>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.Name}"/></td>
<td><c:out value="${row.BirthDate}"/></td>
<td><c:out value="${row.BirthMonth}"/></td>
<td><c:out value="${row.BirthYear}"/></td>
<td><a href="updateDelete.jsp?id=${row.UserId}" style="color: green">Update</a></td>
<td><a href="Delete.jsp?id=${row.UserId}"&action="delete" style="color: #CC0000">Delete</a></td>
</tr>
</c:forEach>
</table>

<br>
<a href="second.jsp">Back</a>

</body>
</html>