/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.ServiceController;

/**
 *
 * @author insaf
 */
public class ServiceControllerImpl extends UnicastRemoteObject implements ServiceController{
    ServiceControllerImpl() throws RemoteException{
        
    }
    
}
