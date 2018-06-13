<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Birthday Reminder Application</title>
<script type = "text/javascript">
 
function emailcheck() {
	
	var emailID = document.getElementById("emailId").value;
	var pwd=document.getElementById("password").value;
    atpos = emailID.indexOf("@");
    dotpos = emailID.lastIndexOf(".");
    if (atpos < 1 || ( dotpos - atpos < 2 ))
    {
        alert("Please enter correct email ID")
        return false;
    }
    else
    	{
    	if(pwd.length>0)
    		{
    		return true;
    		}
    	else
    		{
    		alert("Please enter your password")
            return false;
    		}
    	}
		
		}
</script>
</head>
<body>
<h4>Welcome to Birthday Reminder Application</h4>

<img src="happy.jpg" alt="Angry face" width="500" height="200" />
<form name="validating" action="login" method="post">
<br>
 Email Id: &nbsp;<input type="text" id="emailId" name="emailId" required/>
<br>
Password: <input type="password" id="password" name="password" required/>
<br>
<input type="submit" value="Login" onclick="emailcheck()">
<br>
<br>
</form>
<br>
<a href="login.jsp">New User</a>
<br>
<h5 style="color: green">About Birthday Reminder Application</h5>
<p>
Birthday Reminder Application sends you a reminder each time one of your friends 
is having a birthday. It is also super easy for you to wish them HAPPY BIRTHDAY 
Just sign up and enter your friends birthday information and 
we will notify you by Email.
</p>

</body>
</html>