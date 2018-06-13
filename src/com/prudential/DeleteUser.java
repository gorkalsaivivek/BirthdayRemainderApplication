package com.prudential;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends HttpServlet {
	
DBConnection db=new DBConnection();
	private static final long serialVersionUID = 1L;

	public DeleteUser() {
        super();
} 

	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
	    PrintWriter out = response.getWriter();
		out.println("This is in Post servlet");
		String email=request.getParameter("emailId");
		String name= request.getParameter("name");
		int dateOfBirth=Integer.parseInt(request.getParameter("birthDate"));
		int dateMonth=Integer.parseInt(request.getParameter("birthMonth"));
		int dateYear=Integer.parseInt(request.getParameter("birthYear"));
		
		int result=db.saveRecord(email, name, dateOfBirth, dateMonth, dateYear);
		System.out.println(result);
		if(result==1)
		{
			response.sendRedirect("success.jsp");
		}
		else
		{
			response.sendRedirect("insert.jsp");
		}
		response.setContentType("text/html");
	      out.println(email);
	      out.println("This is in Post servlet");
		
		
}
	
	
}
