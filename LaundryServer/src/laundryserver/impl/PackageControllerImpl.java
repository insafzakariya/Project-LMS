/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import laundrycommon.controller.PackageController;

/**
 *
 * @author insaf
 */
public class PackageControllerImpl extends UnicastRemoteObject implements PackageController{
    PackageControllerImpl() throws RemoteException{
        
    }
}
