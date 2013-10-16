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
    public PackageController getPackageController()throws RemoteException;
    public ServiceController getServiceController() throws RemoteException;
    public MembershipController getMembershipController()throws RemoteException;
    public CustomerController getCustomerController()throws RemoteException;
}
