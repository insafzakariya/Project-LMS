/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import laundrycommon.model.Customer;

/**
 *
 * @author insaf
 */
public interface CustomerController extends Remote{
    public boolean addCustomer(Customer customer)throws RemoteException, SQLException,ClassNotFoundException;
    
}
