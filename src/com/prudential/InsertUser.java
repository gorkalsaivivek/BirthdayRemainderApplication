package com.prudential;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertUser extends HttpServlet {
	
DBConnection db=new DBConnection();
	private static final long serialVersionUID = 1L;

	public InsertUser() {
        super();
}
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
		String email=request.getParameter("emailId");
		String pwd= request.getParameter("password");
		db.saveUser(email,pwd);
		
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("This is my first angular with servlet");
		
		
}
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
		
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
	      PrintWriter out = response.getWriter();
	      out.println(email);
	      out.println("This is in Post servlet");
		
		
}
	
	
	

}

