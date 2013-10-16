/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.idgenarate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JLabel;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author insaf
 */
public class IDGenarate {

    public static void nextID(JLabel label, String prefix, String coloum, String table) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = DBConnection.getConnectionTo();
            String sql = "SELECT " + coloum + " FROM " + table + " ORDER BY 1 DESC LIMIT 1";
            ResultSet resultSet = DBHandel.getData(connection, sql);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(3);
            String current = prefix + "000";

            while (resultSet.next()) {
                current = resultSet.getString(1);

            }

            int index = current.length();
            for (int i = current.length() - 1; i >= 0; i--) {

                String part = current.substring(i, current.length());
                try {
                    Integer.parseInt(part);
                } catch (Exception e) {
                    index = i + 1;
                    break;
                }

            }
            String s = current.substring(index);
            int i = Integer.parseInt(s);
            i++;
            label.setText(current.substring(0, index) + nf.format(i));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
