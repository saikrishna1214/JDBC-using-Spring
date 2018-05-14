package org.imaginea.spring_practice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * In this code a Connection is established to database.
 * DriverManager.getConnection method will take url, username, password
 * as arguments and returns a Connection object if connection is
 * established.
 */

public class ConnectionUtilService implements ConnectionUtil{
	
	private MessageSource messageSource;
    
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	public Connection getConnection() throws IOException, SQLException {
		String host,port,dbname,user,pwd,url;
				host = this.messageSource.getMessage("host",null,"default host",null);
				port = this.messageSource.getMessage("port", null, "default port", null);
				dbname = this.messageSource.getMessage("dbname", null, "default dbname", null);
				user = this.messageSource.getMessage("user", null, "default user", null);
				pwd = this.messageSource.getMessage("pwd", null, "default pwd", null);
		url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
		Connection con = DriverManager.getConnection(url, user, pwd);
        System.out.println("connected..."+con.getClass());
		return con;
	}
	
}
