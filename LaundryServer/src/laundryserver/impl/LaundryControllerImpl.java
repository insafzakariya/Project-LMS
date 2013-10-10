package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.LaundryController;

/**
 *
 * @author Spectore
 */
public class LaundryControllerImpl extends UnicastRemoteObject implements LaundryController{
    LaundryControllerImpl() throws RemoteException{
        
    }
    
}
