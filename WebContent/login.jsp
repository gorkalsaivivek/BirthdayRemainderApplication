<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BirthDay Reminder Application</title>
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
    		alert("Your details are saved!");
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
<form action="validate" method="post">
<h4>Please Sign Up</h4>
<br>
Email Id: <input type="text" id="emailId" name="emailId" required/>
<br>
Password: <input type="password" name="password" required/>
<br>
<input type="submit" value="Save" onclick="return emailcheck()" >
   </form>
</body>
</html>