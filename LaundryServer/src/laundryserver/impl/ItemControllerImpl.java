package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.ItemController;

/**
 *
 * @author Spectore
 */
public class ItemControllerImpl extends UnicastRemoteObject implements ItemController{
    
    ItemControllerImpl() throws RemoteException{
        
    }
    
}
