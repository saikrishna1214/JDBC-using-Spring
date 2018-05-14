package org.imaginea.spring_practice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.stereotype.Component;

/**
 * impl
 *
 */

public class CRUDOperationService implements CRUDOperations{
	
	/**
	 * This code will inserts the given data into students table 
	 * by taking data as input using scanner class.
	 * 
	 * @Connection establishes connection with database and an object
	 * of type Connection class is passed as an argument.
	 */
	
	public int insert(Connection con) throws SQLException {
		
		PreparedStatement ps;
		int m = 0;
    	Scanner sc = new Scanner(System.in);
    	
        String s2 = "insert into students values(?,?,?)";
        ps = con.prepareStatement(s2);
        
        System.out.println("enter no. of students: ");
        int n = sc.nextInt();
        
        while(n-->0)
        {
        	System.out.println("enter student details(name,id,branch) in order: ");
        	String name = sc.next();
        	int id = sc.nextInt();
        	String branch = sc.next();
        	ps.setString(1, name);
        	ps.setInt(2, id);
        	ps.setString(3, branch);
        	ps.executeUpdate();
        }
		
        return m;
	}

	/**
	 * this code will delete data from tables in our database
	 * student id is used to delete a respective row from database.
	 * 
	 */
	
	public int delete(Connection con) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		String s1 = "delete from students where id=?";
		PreparedStatement ps = con.prepareStatement(s1);
		
		System.out.println("enter the student id to delete : ");
		
		int id = sc.nextInt();
		
		ps.setInt(1,id);
		
		int tmp = ps.executeUpdate();
		
		System.out.println("values deleted...");
		
		return tmp;
		
	}

	/**
	 * 
	 * all the data in the tables will be printed in this code.
	 * values from tables are taken by using getString() , getInt() methods.
	 * 
	 * @author saikrishnak
	 *
	 */
	
	public boolean update(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);
        System.out.println("enter the row no. to update : ");
        int rno = sc.nextInt();
        System.out.println("enter modified details : ");
        String name = sc.next();
    	int id = sc.nextInt();
    	String branch = sc.next();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String s1 = "select name,id,branch from students";
        ResultSet rs = st.executeQuery(s1);
        rs.absolute(rno);
        rs.updateString(1, name);
        rs.updateInt(2, id);
        rs.updateString(3, branch);
        rs.updateRow();
		System.out.println("values updated...");
		return rs.first();
		
	}

	public boolean read(Connection con) throws SQLException {
		
		String s1 = "select *from students";
        
        Statement st = con.createStatement();
        
        /**
         * SQL statement is passed to executeQuery method of Statement class
         * which will return Object of ResultSet type. 
         */
      
        ResultSet rs = st.executeQuery(s1);
        boolean temp;
        
        /**
         * next() Moves the cursor forward one row from its current position. 
         *
         * When a call to the next method returns false, the cursor is positioned
         *  after the last row.
         */
        
        while(temp=rs.next())
        {
        	System.out.print(rs.getRow()+"  ");
        	
        	/*prints data in each row */
        	
        	System.out.print(rs.getInt(2)+"  ");
        	System.out.print(rs.getString(3));
        	System.out.println();
        }
        /* returns false if all rows are printed */
        return temp;
		
	}

}
