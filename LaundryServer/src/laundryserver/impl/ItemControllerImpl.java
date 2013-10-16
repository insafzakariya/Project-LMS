package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.controller.ItemController;
import laundrycommon.model.Item;

/**
 *
 * @author Spectore
 */
public class ItemControllerImpl extends UnicastRemoteObject implements ItemController {

    private static ItemDBAccess ida = new ItemDBAccess();

    ItemControllerImpl() throws RemoteException {
    }

    @Override
    public ArrayList<Item> getAll() throws RemoteException, SQLException, ClassNotFoundException {
        return ida.getAll();
    }

    @Override
    public String[] getCategories() throws RemoteException, SQLException, ClassNotFoundException {
        return ida.getCategories();
    }
}
