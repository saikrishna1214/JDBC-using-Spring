package org.imaginea.springPractice;



import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.imaginea.spring_practice.CRUDOperations;
import org.imaginea.spring_practice.ConnectionUtil;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *  tests the code with given input data.
 */

public class AppTest 
    {
	
	static private ConnectionUtil connect;
	static private Connection con;
	static private CRUDOperations crudop;
	
	/**
	 *  connects to data base and stores returned object in con variable.
	 *  creates object for CRUDOperations and ConnectionUtil class.
	 */
	@BeforeClass
	public static void connectToDatabase() throws IOException, SQLException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		crudop = (CRUDOperations) context.getBean("crudOperations");
		connect = (ConnectionUtil) context.getBean("getConnection");
		con = connect.getConnection();
	}
	
	

	/**
	 * closes connection after testing data
	 */
	@AfterClass
	public static void closeConnection() throws SQLException
	{
		con.close();
	}	
	
	/**
	 *  tests the insert function returns 0 if data is inserted 
	 *  1 if data is not inserted
	 */
	@org.junit.Test
	public void testInsert()throws SQLException, IOException
	{
		String str = "1 ravi 111 eee";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);
		assertEquals(0, crudop.insert(con));
	}
	
	/**
	 * tests whether data is deleted properly or not 
	 * returns 1 if data is deleted properly otherwise 0.
	 */
	@org.junit.Test
	public void testDelete() throws SQLException
	{
		String str = "207";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);
		assertEquals(1, crudop.delete(con));
	}
	

	/**
	 * returns true if data is properly printed other wise false.
	 */
	@org.junit.Test
	public void testResult()throws SQLException
	{
		assertEquals(false, crudop.read(con));
	}
	
	/**
	 * tests whether data is correctly updated or not
	 * @throws SQLException
	 */
	@org.junit.Test
	public void testUpdate()throws SQLException
	{
		String str = "2 raju 122 ece";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);
		assertEquals(true, crudop.update(con));
	}

}
