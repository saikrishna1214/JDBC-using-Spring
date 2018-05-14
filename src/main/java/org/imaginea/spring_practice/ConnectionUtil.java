package org.imaginea.spring_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionUtil {
	
	public Connection getConnection()  throws IOException, SQLException; 

}
