/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author insaf
 */
public class DBConnection {
    private static DBConnection dBConnection;
    private Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost/laundry","root","insaf");
    }
    private static DBConnection createDBConnection() throws ClassNotFoundException, SQLException{
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
    private Connection getConnection(){
        return connection;
    }
    public static Connection getConnectionTo() throws  ClassNotFoundException, SQLException{
        return DBConnection.createDBConnection().getConnection();
    }
    
}
