package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.controller.CustomerController;
import laundrycommon.model.Customer;
import laundryserver.dbaccess.CustomerDBAccess;

/**
 *
 * @author Sentinel
 */
public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController{
    private static CustomerDBAccess customerDBAccess=new CustomerDBAccess();
    CustomerControllerImpl() throws RemoteException{
        
    }

    @Override
    public boolean addCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
       return customerDBAccess.addCustomer(customer);
    }

    @Override
    public ArrayList<Customer> getAll() throws RemoteException, SQLException, ClassNotFoundException{
        return customerDBAccess.getAll();
    }
    
}
