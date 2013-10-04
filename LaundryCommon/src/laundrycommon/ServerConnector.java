/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundrycommon;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import laundrycommon.controller.ItemController;
import laundrycommon.controller.LaundryController;
import laundrycommon.controller.MemberController;
import laundrycommon.controller.PackageController;
import laundrycommon.controller.RemoteFactory;
import laundrycommon.controller.ServiceController;

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
    
    
    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        remoteFactory= (RemoteFactory) Naming.lookup("rmi://localhost:REGISTRY_PORT/LaundryFactory");
        
    }
    
    private static ServerConnector createServerConnector() throws NotBoundException, MalformedURLException, RemoteException{
        if(serverConnector==null){
            serverConnector=new ServerConnector();
        }
        return serverConnector;
        
    }
    private RemoteFactory getRemoteFactory(){
        return remoteFactory;
        
    }
    
    private MemberController getMemberController() throws RemoteException{
        if(memberController==null){
            memberController=remoteFactory.getMemberController();
        }
   
        return memberController;
        
    }
    private ItemController getItemController() throws RemoteException{
        if(itemController==null){
            itemController=remoteFactory.getItemController();
        }
        return null;
        
    }
    private LaundryController getLaundryController() throws RemoteException{
       if(laundryController==null){
           laundryController=remoteFactory.getLaundryController();
       }
       return laundryController;
        
    }
    private PackageController getPackageController(){
        return null;
        
    }
    private ServiceController serviceController(){
        return null;
        
    }
    
    
}
