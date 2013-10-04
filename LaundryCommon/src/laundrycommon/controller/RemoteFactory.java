package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Prashan
 */
public interface RemoteFactory extends Remote {

    public LaundryController getLaundryController() throws RemoteException;
    public ItemController getItemController() throws RemoteException;
    public MemberController getMemberController() throws RemoteException;
}