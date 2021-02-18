package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionsDemo
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
        
        //open a connection
    	System.out.println("Connection to database.....");
    			
         //Open a connection
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd");
         
         System.out.println("Driver is Loaded");
         
         Statement stmt = con.createStatement();
         
         con.setAutoCommit(false);
         try
         {
        	 int i1 = stmt.executeUpdate("insert into candidate_skills values(100,3)");
        	 int i2 = stmt.executeUpdate("update skills set name = 'Ruby' where id = 1");
        	 int i3 = stmt.executeUpdate("delete from candidates where id = 0");
        	 
        	 con.commit();
        	 
        	 System.out.println("Transaction is success!!");
        	 
         }
         catch(Exception e)
         {
        	 try 
             {
            	 con.rollback();
            	 System.out.println("**Transaction failed");
            	 System.out.println("Exception is "+e);
            	 
             }
        	 catch(Exception e1)
        	 {
        		 System.out.println("Exception is "+e1);
        	 }
         }
        	 // end of outer catch
        	 //cleanup
        	 stmt.close();
        	 con.close();
        	 System.out.println("connection is closed");
        	 
        	 
         
		

	}

}
