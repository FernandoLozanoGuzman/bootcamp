package com.everis.pruebaMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	static Connection connection=null;
    public static void main( String[] args )
    {
        connection = connect();
        consulta(connection);
        desconectar(connection);
        
    }
    
    public static Connection connect(){
 	   try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("localhost:8080/nttdata_database","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	   return connection;
    }
    
    public static void desconectar(Connection conn){
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void consulta(Connection conn){
		try {
	    	Statement sentence = conn.createStatement();
	    	String select="Select playerName from NTTDATA_ORACLE_SOCCER_TEAM";
	    	ResultSet rs=sentence.executeQuery(select);
	    	while(rs.next()) {
    			System.out.println(rs);
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}
