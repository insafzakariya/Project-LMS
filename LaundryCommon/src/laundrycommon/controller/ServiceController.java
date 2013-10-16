package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Service;

/**
 *
 * @author Sentinel
 */
public interface ServiceController extends Remote{
    public ArrayList<Service> getAll() throws RemoteException, SQLException, ClassNotFoundException;
}
