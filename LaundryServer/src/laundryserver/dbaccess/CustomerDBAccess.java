/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.dbaccess;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import laundrycommon.model.Customer;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author insaf
 */
public class CustomerDBAccess {

    public boolean addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
        boolean check = false;
        try {


            Connection connection = DBConnection.getConnectionTo();
            String sql = "INSERT INTO customer(cid,name,telephone)" + "values(?,?,?)";
            Object data[] = {customer.getCid(), customer.getName(), customer.getTelNo()};

            int res = DBHandel.setData(connection, sql, data);


            if (res > 0) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
