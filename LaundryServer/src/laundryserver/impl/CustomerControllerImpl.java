/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import laundrycommon.controller.CustomerController;
import laundrycommon.model.Customer;
import laundryserver.dbaccess.CustomerDBAccess;

/**
 *
 * @author insaf
 */
public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController{
    private static CustomerDBAccess customerDBAccess=new CustomerDBAccess();
    CustomerControllerImpl()throws RemoteException{
        
    }

    @Override
    public boolean addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
       return customerDBAccess.addCustomer(customer);
        
    }
    
}
