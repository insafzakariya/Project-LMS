package laundryserver.controller;

import controller.ItemController;
import controller.LaundryController;
import controller.MemberController;
import controller.PackageController;
import controller.ServiceController;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Prashan
 */
public interface RemoteFactory extends Remote {
    public LaundryController getLaundryController() throws RemoteException;
    public ItemController getItemController() throws RemoteException;
    public MemberController getMemberController() throws RemoteException;
    public ServiceController getServiceController() throws RemoteException;
    public PackageController getPackageController() throws RemoteException;
}
