package org.imaginea.spring_practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public interface CRUDOperations 
{
    public int insert (Connection con) throws SQLException;
    public int delete (Connection con)throws SQLException;
    public boolean update (Connection con)throws SQLException;
    public boolean read (Connection con)throws SQLException;
}
