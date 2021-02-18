package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args)
	{
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try
		{
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//open a connection
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			//creating statement object using connection obj
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd");
			
			stmt = con.createStatement();
			
			//Execute a query
			rs = stmt.executeQuery("select * from candidates");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+">>>>>>"+rs.getString(2)+" "+rs.getString(3)+">>>>>>"+rs.getDate(4)+">>>>>>"+rs.getString(5)+">>>>>>"+rs.getString(6));
				
				
			}
			rs.close();
			stmt.close();
			con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
