package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Sentinel
 */
public interface ServiceItemCostController extends Remote{
    public float getCost(int serviceID, int itemID) throws RemoteException, SQLException, ClassNotFoundException;
}
