package com.prudential;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUser extends HttpServlet {
	
DBConnection db=new DBConnection();
	private static final long serialVersionUID = 1L;

	public UpdateUser() {
        super();
}
	public void doPost(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException
{
		HttpSession sess = request.getSession(); 
		int id=Integer.parseInt(request.getParameter("inputId"));
		String email=request.getParameter("emailId");
		String name= request.getParameter("name");
		int dateOfBirth=Integer.parseInt(request.getParameter("birthDate"));
		int dateMonth=Integer.parseInt(request.getParameter("birthMonth"));
		int dateYear=Integer.parseInt(request.getParameter("birthYear"));
		
		int result=db.updateRecord(id,email, name, dateOfBirth, dateMonth, dateYear);
		System.out.println(result);
		if(result==1)
		{
			response.sendRedirect("successUpdate.jsp");
		}
		else
		{
			response.sendRedirect("updateDelete.jsp");
		}
		response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println(email);
	      out.println("This is in Post servlet");
		
		
}
	

}
