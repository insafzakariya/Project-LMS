package laundryserver.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Item;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author Sentinel
 */
class ItemDBAccess {

     ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT * FROM item");
        ArrayList<Item> itemList = new ArrayList<>();
        while(rst.next()){
            itemList.add(new Item(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return itemList;
    }
    
}
