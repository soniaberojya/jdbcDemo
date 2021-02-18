package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) 
	{
		Connection con;
        Statement stmt;
        ResultSet rs;
        int cnt = 0;
        
        try {
        // Register JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver"); 
                    
                    //open a connection
        			System.out.println("Connection to database.....");
        			
                    //Open a connection
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd");
                   
                    //Execute a query
                    String str = "INSERT INTO skills(name)"+"VALUES('C#')";
                    
                    stmt = con.createStatement();
                    int rowcount = stmt.executeUpdate(str);
                    if(rowcount > 0)
                    {
                    	System.out.println("Record Inserted Successfully!!");
                    }
                    
                    String str1 = "select count(id) from skills";
                    rs = stmt.executeQuery(str1);
                    while(rs.next())
                    {
                    	cnt = rs.getInt(1);
                    }
                    System.out.println("Total number of records is "+cnt);
                    con.close();
                    stmt.close();
                    rs.close();
                                  

	    }
        catch(Exception e)
        {
        	System.out.println(e);
        }

}
}
