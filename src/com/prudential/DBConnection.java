package com.prudential;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	
	private static Connection connection = null;
    //1.jdbc driver name
    private static String SQL_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // 2. Database URL
    private static String URL = "jdbc:sqlserver://127.0.0.1:56194;databaseName=birthday;instanceName=SQLEXPRESS";
    //3.Database credentials
    private static String USERNAME = "sgorkal";//UserName
    private static String PASSWORD = "infy1234";//Password
    private static String query="select * from LoginInfo";
    Connection conObj;
    
    
    public void getConnection()
    {
    		
		// STEP 4 --> get the Connection object from DriverManagerService
    	
		try {
			Class.forName(SQL_JDBC_DRIVER);
			conObj = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		//  STEP 5 --> Create the statement Object which provides communication to db
//			PreparedStatement psObj;
//			psObj = conObj.prepareStatement(query);
//			
//			ResultSet rs=psObj.executeQuery();
//			while(rs.next())
//			{
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

    }
    
    public int saveUser(String a, String b)
    {
    	String query1="Insert into LoginInfo values (?,?)";
    	try
    	{
    		getConnection();
    		PreparedStatement psObj;
			psObj = conObj.prepareStatement(query1);
    		psObj.setString(1, a);
    		psObj.setString(2, b);
    		int res=psObj.executeUpdate();
    	
    			return res;   		
    		
    	}
    	catch(Exception e)
    	{
    		
    	}
		return 0;
    	
    }
    
    public int checkUser(String a, String b)
    {
    	String query1="Select * from LoginInfo where Email=? and Password=?";
    	try
    	{
    		getConnection();
    		PreparedStatement psObj;
			psObj = conObj.prepareStatement(query1);
    		psObj.setString(1, a);
    		psObj.setString(2, b);
    		ResultSet rs=psObj.executeQuery();
    		while(rs.next())
    		{
    			return 1;
    		}
    		
    		
    		
    	}
    	catch(Exception e)
    	{
    		
    	}
		return 0;
    	
    }
    public int saveRecord(String a, String b,int c, int d, int e)
    {
    	String query1="Insert into UserInfo values (?,?,?,?,?)";
    	try
    	{
    		getConnection();
    		PreparedStatement psObj;
			psObj = conObj.prepareStatement(query1);
    		psObj.setString(1, a);
    		psObj.setString(2, b);
    		psObj.setInt(3, c);
    		psObj.setInt(4, d);
    		psObj.setInt(5, e);
    		int res=psObj.executeUpdate();
    		
    		return res;
    		
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	
		return 0;
    	
    }
    
    
    
    public List displayAccount()
    {
    	List<Integer> l=new ArrayList<>();
    	String query1="Select Ac_No from Account";
    	try
    	{
    		getConnection();
    		PreparedStatement psObj;
			psObj = conObj.prepareStatement(query1);
			
			ResultSet rs=psObj.executeQuery();
			
			while(rs.next())
			{
				l.add(Integer.parseInt(rs.getString(1)));
			}
    	}
    	catch(Exception e)
    	{
    		
    	}
		return l;
    }

	public int updateRecord(int id, String email, String name, int dateOfBirth, int dateMonth, int dateYear) {
		// TODO Auto-generated method stub
		
		String query1="Update UserInfo SET Name= ?, BirthDate= ?,BirthMonth= ?,BirthYear= ? WHERE UserId=? ";
    	try
    	{
    		getConnection();
    		PreparedStatement psObj;
			psObj = conObj.prepareStatement(query1);
    		psObj.setString(1, name);
    		psObj.setInt(2, dateOfBirth);
    		psObj.setInt(3, dateMonth);
    		psObj.setInt(4, dateYear);
    		psObj.setInt(5, id);
    		int res=psObj.executeUpdate();
    		
    		return res;
    		
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	
		
		
		return 0;
	}

	



}
