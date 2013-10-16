package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.controller.ServiceController;
import laundrycommon.model.Service;
import laundryserver.dbaccess.ServiceDBAccess;

/**
 *
 * @author Sentinel
 */
public class ServiceControllerImpl extends UnicastRemoteObject implements ServiceController {
    private static ServiceDBAccess sda = new ServiceDBAccess();
    ServiceControllerImpl() throws RemoteException {  }

    @Override
    public ArrayList<Service> getAll() throws RemoteException, SQLException, ClassNotFoundException {
        return sda.getAll();
    }
}
