package com.prudential;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidate extends HttpServlet {
	
DBConnection db=new DBConnection();
	private static final long serialVersionUID = 1L;

	public LoginValidate() {
        super();
}
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
//		String email=request.getParameter("emailId");
//		String pwd= request.getParameter("password");
//		db.saveUser(email,pwd);
//		
//		response.setContentType("text/html");
//	      PrintWriter out = response.getWriter();
//	      out.println("This is my first angular with servlet");
//		
		
}
	
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
		
		String email=request.getParameter("emailId");
		String pwd= request.getParameter("password");
		
		int result=db.saveUser(email,pwd);
		if(result==1)
		{
			response.sendRedirect("home.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println(email);
	      out.println(pwd);
	      out.println("This is in Post servlet");
		
		
}
	
	
	

}
