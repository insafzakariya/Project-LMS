package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.MemberController;

/**
 *
 * @author Spectore
 */
public class MemberControllerImpl extends UnicastRemoteObject implements MemberController{
    MemberControllerImpl() throws RemoteException{
        
    }
    
}
