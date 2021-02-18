package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//JDBC program to display candidate details and heir skills
public class JoinsDemo 
{

	public static void main(String[] args) 
	{
		Connection con;
        Statement stmt;
        ResultSet rs;
        try {
        // Register JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");    
                    //Open a connection
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd");
                    //Execute a query
                    stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  //scrollable result set
                    rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  candidate_skills s ON c.id=candidate_id  INNER JOIN  skills sk ON s.skill_id=sk.id  ;");
                    
                    //Execute data from resultSet
                  //Extract data from result set
        			while(rs.next())
        			{
        				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
        				
        				
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


