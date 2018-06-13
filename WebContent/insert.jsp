<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add your friend</title>
Welcome <%=(String)session.getAttribute("emailtoAnotherPage")%> 
</head>
<body>

<form action="saveRecord" method="post">
<br>
   Email ID:<input type="text" name="emailId" value=<%=(String)session.getAttribute("emailtoAnotherPage")%> readonly="readonly"/> 
   <br>
   Name :<input type="text" name="name" required />
    <br>
   BirthDate<input type="text" name="birthDate" required/>
    <br>
   BirthMonth<input type="text" name="birthMonth" required/>
    <br>
   BirthYear<input type="text" name="birthYear" required/>
    <br>
   <input type="submit" value="Save" >
   <a href="second.jsp">Back</a>
   <hr/>
   </form>
</body>
</html>