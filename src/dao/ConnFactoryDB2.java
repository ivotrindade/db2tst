/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * ATTENTION: replace userid Zxxxxx with your zxplore id and "password" with 
 *            your password.
 *
 *
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ivo
 */
public class ConnFactoryDB2 {
    
    private volatile static Connection uniqueConn;
	
	private ConnFactoryDB2() {}
	
	public static Connection getConnection() throws SQLException {
	  if (uniqueConn == null) {
		synchronized (ConnFactoryDB2.class) { 
	       if (uniqueConn == null) {
				try {
                                    System.out.println("Connecting DB DALLASC - IBM Zxplore!");
					Class.forName("com.ibm.db2.jcc.DB2Driver");
					uniqueConn = DriverManager.getConnection("jdbc:db2://204.90.115.200:5040/DALLASC", "Zxxxxx", "password");
					
					} catch (ClassNotFoundException e) {
					throw new SQLException(e.getMessage());
					}
				}
		}
	  }
	  return uniqueConn;
	}
    
}
