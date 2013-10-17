package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.PackageController;

/**
 *
 * @author Sentinel
 */
public class PackageControllerImpl extends UnicastRemoteObject implements PackageController{
    PackageControllerImpl() throws RemoteException{
        
    }
}
