/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author insaf
 */
public class DBHandel {

    public static int setData(Connection connection, String sql, Object[] data) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < data.length; i++) {
            preparedStatement.setObject((i + 1), data[i]);

        }
        int res = preparedStatement.executeUpdate();
        System.out.println("res"+res);

        return res;

    }
    public static ResultSet getData(Connection connection,String string) throws SQLException{
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(string);
        return resultSet;
        
    }
    public static int  setSingleData(Connection connection,String sql) throws SQLException{
        Statement statement=connection.createStatement();
        int res=statement.executeUpdate(sql);
        
        return res;
        
    }
}
