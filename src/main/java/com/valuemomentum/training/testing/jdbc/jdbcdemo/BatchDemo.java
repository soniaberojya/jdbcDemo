package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDemo 
{

	public static void main(String[] args) throws Exception
	{
		// Register JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver"); 
                
        //open a connection
    	System.out.println("Connection to database.....");
    			
         //Open a connection
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd");
         
         Statement stmt = con.createStatement();
         
         // create batch
         stmt.addBatch("INSERT into candidate_skills values(100,5)");
         stmt.addBatch("UPDATE Skills set name = 'Ajax' where id= 3");
         stmt.addBatch("delete from candidates where id = 80");
         
         //disable auto-commit mode
         con.setAutoCommit(false);
         try
         {
        	 stmt.executeBatch();
        	 con.commit();
        	 System.out.println("batch is successfully executed");
         }
         catch(Exception e)
         {
        	 try 
             {
            	 con.rollback();
            	 System.out.println("batch is failed");
            	 System.out.println("Exception is "+e);
            	 
             }
        	 catch(Exception e1)
        	 {
        		 System.out.println("Exception is "+e1);
        	 }
        	 // end of outer catch
        	 //cleanup
        	 stmt.close();
        	 con.close();
         }
         
	}

}
