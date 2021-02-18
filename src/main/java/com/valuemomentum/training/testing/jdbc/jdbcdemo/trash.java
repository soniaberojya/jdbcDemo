package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class trash {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mysqljdbc","root","Passw0rd";
		try { Connection conn = DriverManager.getConnection(url); 
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("select count(*) from candidates") ;
		    System.out.println(rs.getInt(1)); } 
		catch(Exception e){ System.out.println(e);}
		// TODO Auto-generated method stub

	}

}
