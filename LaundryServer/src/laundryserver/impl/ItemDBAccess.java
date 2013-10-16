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
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT * FROM item order by category");
        ArrayList<Item> itemList = new ArrayList<>();
        
        while (rst.next()) {
            itemList.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3)));
        }
        return itemList;
    }

    String[] getCategories() throws SQLException, ClassNotFoundException {
        ResultSet rst = DBHandel.getData(DBConnection.getConnectionTo(), "SELECT DISTINCT category FROM item");
        rst.last();
        String categories[] = new String[rst.getRow()];
        rst.beforeFirst();
        
        int i=0;
        while (rst.next()) {
            categories[i++] = rst.getString(1);
        }
        return categories;
    }
}
