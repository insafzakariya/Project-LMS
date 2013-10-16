package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Item;

/**
 *
 * @author Sentinel
 */
public interface ItemController extends Remote{
    public ArrayList<Item> getAll() throws RemoteException, SQLException, ClassNotFoundException;
    public String[] getCategories() throws RemoteException, SQLException, ClassNotFoundException;
}
