<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<% Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
<h4>Record Deleted Successfully.</h4>
</head>
<body>
<% 
            Connection connection = DriverManager.getConnection(
            		"jdbc:sqlserver://127.0.0.1:56194;databaseName=birthday;instanceName=SQLEXPRESS", "sgorkal", "infy1234");
String selectSQL = "Delete from UserInfo where UserId=?";
PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
int a = Integer.parseInt(request.getParameter("id"));
preparedStatement.setInt(1, a);
preparedStatement.executeUpdate(); 
 %>

<form action="delete" method="post">
<br>
<input type="hidden"  name="inputId" value=<%=Integer.parseInt(request.getParameter("id")) %> />
</form>
<h4>Record Deleted Successfully.</h4>
</body>
</html>