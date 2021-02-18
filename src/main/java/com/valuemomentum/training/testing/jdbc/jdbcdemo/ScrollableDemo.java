package com.valuemomentum.training.testing.jdbc.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {

	 

    public static void main(String[] args) {
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
                    rs=stmt.executeQuery("select * from skills");
                    
                    //Execute data from resultSet
                    while(rs.next()) {
                    
                        System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
                    }
                    System.out.println("*************************");
                    // moves cursor to 3rd row
                    rs.absolute(3);
                    System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
                    System.out.println("*************************");
                    //moves cursor to 2nd row
                    rs.relative(-1);
                    System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
                    System.out.println("*************************");
                    
                    int i=rs.getRow();
                    System.out.println("Current row position"+i);
                    con.close();
                }
                catch(Exception e) {
                    e.getMessage();
                }    

 

    }

 

}