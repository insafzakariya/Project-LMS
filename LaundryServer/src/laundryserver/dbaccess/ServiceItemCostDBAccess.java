package laundryserver.dbaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author Sentinel
 */
public class ServiceItemCostDBAccess {

    public float getCost(int serviceID, int itemID) throws ClassNotFoundException, SQLException {
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT cost FROM given_to where sid='"+serviceID+"' AND iid='"+itemID+"'");
        float cost=-1;
        try{
            rst.next();
            cost=rst.getInt(1);
        }catch(Exception e){
            return cost;
        }
        return cost;
    }
}
