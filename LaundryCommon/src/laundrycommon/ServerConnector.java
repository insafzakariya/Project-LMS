/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundrycommon;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import laundrycommon.controller.CustomerController;
import laundrycommon.controller.ItemController;
import laundrycommon.controller.LaundryController;
import laundrycommon.controller.MemberController;
import laundrycommon.controller.MembershipController;
import laundrycommon.controller.PackageController;
import laundrycommon.controller.RemoteFactory;
import laundrycommon.controller.ServiceController;
import laundrycommon.controller.ServiceItemCostController;

/**
 *
 * @author insaf
 */
public class ServerConnector {
    private static ServerConnector serverConnector;
    private RemoteFactory remoteFactory;
    private MemberController memberController;
    private ItemController itemController;
    private LaundryController laundryController;
    private PackageController packageController;
    private MembershipController membershipController;
    private CustomerController customerController;
    private ServiceController serviceController;
    private ServiceItemCostController serviceItemCostController;
    
    
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        remoteFactory= (RemoteFactory) Naming.lookup("rmi://localhost:5050/LaundryFactory");
        
    }
    
    public static ServerConnector getServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        if(serverConnector==null){
            serverConnector=new ServerConnector();
        }
        return serverConnector;
        
    }
    private RemoteFactory getRemoteFactory(){
        return remoteFactory;
        
    }
    
    public MemberController getMemberController() throws RemoteException{
        if(memberController==null){
            memberController=remoteFactory.getMemberController();
        }
   
        return memberController;
        
    }
   public ItemController getItemController() throws RemoteException{
        if(itemController==null){
            itemController=remoteFactory.getItemController();
        }
        return itemController;
        
    }
   public LaundryController getLaundryController() throws RemoteException{
       if(laundryController==null){
           laundryController=remoteFactory.getLaundryController();
       }
       return laundryController;
        
    }
    public PackageController getPackageController(){
        return null;
        
    }
    public ServiceController getServiceController() throws RemoteException{
        if(serviceController == null){
            serviceController = remoteFactory.getServiceController();
        }
        return serviceController;
    }
    public MembershipController getMemberShipController() throws RemoteException{
        if(membershipController==null){
            membershipController=remoteFactory.getMembershipController();
        }
        return membershipController;
    }
    public CustomerController getCustomerController()throws RemoteException{
        if(customerController==null){
            customerController=remoteFactory.getCustomerController();
        }
        return customerController;
    }

    public ServiceItemCostController getServiceItemCostController() throws RemoteException {
        if(serviceItemCostController==null){
            serviceItemCostController = remoteFactory.getServiceItemCostController();
        }
        return serviceItemCostController;
    }

}
