package laundryserver.impl;

import laundrycommon.controller.ItemController;
import laundrycommon.controller.LaundryController;
import laundrycommon.controller.MemberController;
import laundrycommon.controller.PackageController;
import laundrycommon.controller.ServiceController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.MembershipController;
import laundrycommon.controller.RemoteFactory;

/**
 * @author Prashan
 */
public class RemoteFactoryImpl extends UnicastRemoteObject implements RemoteFactory {

    public RemoteFactoryImpl() throws RemoteException {
    }

    @Override
    public LaundryController getLaundryController() throws RemoteException {
        return new LaundryControllerImpl();
    }

    @Override
    public MemberController getMemberController() throws RemoteException {
        return new MemberControllerImpl();
    }

    @Override
    public ItemController getItemController() throws RemoteException {
        return new ItemControllerImpl();
    }

    @Override
    public ServiceController getServiceController() throws RemoteException {
        return new ServiceControllerImpl();
    }

    @Override
    public PackageController getPackageController() throws RemoteException {
        return new PackageControllerImpl();
    }

    @Override
    public MembershipController getMembershipController() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
