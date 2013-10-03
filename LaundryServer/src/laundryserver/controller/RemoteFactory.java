package laundryserver.controller;

import laundrycommon.controller.ItemController;
import laundrycommon.controller.LaundryController;
import laundrycommon.controller.MemberController;
import laundrycommon.controller.PackageController;
import laundrycommon.controller.ServiceController;
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
