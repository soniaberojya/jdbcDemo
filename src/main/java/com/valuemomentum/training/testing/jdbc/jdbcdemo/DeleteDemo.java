package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo 
{

	public static void main(String[] args) 
	{
		 Connection con;
	        Statement stmt;
	        ResultSet rs;
	        int cn=0;
	        try {
	             Class.forName("com.mysql.cj.jdbc.Driver");

	 

	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "Passw0rd");
	            String str = "Delete from candidates where rtrim(last_name) like\'Y%g\'";
	            //String str="delete from skills where name='HTML5'";		           
	            stmt = con.createStatement(); 
	            int cnt= stmt.executeUpdate(str);
	            if(cnt>0) 
	            {
	                System.out.println(" Record for Yound Deleted successfully!!");
	            }
	            else
	            {
	            	System.out.println("Record not found");
	            }
	            con.close();
	        } 
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	                    }
	    }

	}

