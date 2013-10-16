package laundryserver.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Service;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author Sentinel
 */
public class ServiceDBAccess {
    public ArrayList<Service> getAll() throws ClassNotFoundException, SQLException {
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT * FROM service");
        ArrayList<Service> serviceList = new ArrayList<>();
        while(rst.next()){
            serviceList.add(new Service(rst.getInt(1),rst.getString(2)));
        }
        return serviceList;
    }
}
