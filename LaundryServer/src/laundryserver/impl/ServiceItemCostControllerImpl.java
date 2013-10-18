package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import laundrycommon.controller.ServiceItemCostController;
import laundryserver.dbaccess.ServiceItemCostDBAccess;

/**
 *
 * @author Sentinel
 */
public class ServiceItemCostControllerImpl extends UnicastRemoteObject implements ServiceItemCostController{
    ServiceItemCostDBAccess sicdba = new ServiceItemCostDBAccess();
    
    public ServiceItemCostControllerImpl() throws RemoteException {   }
    
    @Override
    public float getCost(int serviceID, int ItemID) throws RemoteException, SQLException, ClassNotFoundException {
        return sicdba.getCost(serviceID,ItemID);
    }
}
