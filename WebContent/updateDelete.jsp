<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<% Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
Welcome <%=(String)session.getAttribute("emailtoAnotherPage")%> 
</head>
<body>
<% 
            Connection connection = DriverManager.getConnection(
            		"jdbc:sqlserver://127.0.0.1:56194;databaseName=birthday;instanceName=SQLEXPRESS", "sgorkal", "infy1234");
String selectSQL = "select * from UserInfo where UserId=?";
PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
int a = Integer.parseInt(request.getParameter("id"));
preparedStatement.setInt(1, a);
  

            ResultSet resultset = 
            		preparedStatement.executeQuery(); 

            if(!resultset.next()) {
                out.println("Sorry, could not find that publisher. ");
            } else {
        %>


<form action="updateRecord" method="post">
<br>
<input type="hidden"  name="inputId" value=<%=resultset.getString(1) %> />
   Email ID:<input type="text" name="emailId" value=<%=resultset.getString(2) %> readonly="readonly"/> 
   <br>
   Name :<input type="text" name="name" value=<%=resultset.getString(3) %> required/>
    <br>
   BirthDate<input type="text" name="birthDate" value=<%=resultset.getString(4) %> required/>
    <br>
   BirthMonth<input type="text" name="birthMonth" value=<%=resultset.getString(5) %> required/>
    <br>
   BirthYear<input type="text" name="birthYear" value=<%=resultset.getString(6) %> required/>
    <br>
    <br>
   <input type="submit" value="Update">
   <hr/>
   </form>
   <% 
           } 
       %>
</body>
</html>