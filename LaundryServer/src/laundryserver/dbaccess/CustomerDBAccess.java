package laundryserver.dbaccess;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Customer;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author Sentinel
 */
public class CustomerDBAccess {

    public boolean addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
        boolean check = false;
        Connection connection = DBConnection.getConnectionTo();
        String sql = "INSERT INTO customer(cid,name,telephone)" + "values(?,?,?)";
        Object data[] = {customer.getCid(), customer.getName(), customer.getTelNo()};

        int res = DBHandel.setData(connection, sql, data);

        if (res > 0) {
            check = true;
        }
        return check;
    }

    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT * FROM customer");
        ArrayList<Customer> customerList = new ArrayList<>();
        while(rst.next()){
            customerList.add(new Customer(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return customerList;
    }
}
