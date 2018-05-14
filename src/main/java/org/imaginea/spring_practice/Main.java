package org.imaginea.spring_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[]) throws SQLException, IOException
	{
		Scanner sc = new Scanner(System.in);
		ApplicationContext context  = new ClassPathXmlApplicationContext("spring.xml");
		CRUDOperations crudOperations = (CRUDOperations) context.getBean("crudOperations");
		ConnectionUtil connect = (ConnectionUtil) context.getBean("getConnection");
		Connection con = connect.getConnection();
		System.out.println("enter: 1.to insert details \n 2. to update \n 3. to print results \n 4. to delete \n 5. to exit");
		while(true)
		{
			System.out.println("enter your choice : ");
			int n = sc.nextInt();
			switch(n)
			{
			case 1:	
				crudOperations.insert(con);
				break;
			case 2:
				crudOperations.update(con);
				break;
			case 3:
				crudOperations.read(con);
			case 4:
				crudOperations.delete(con);
			}
			if(n==5)
				break;
		}
	}

}
