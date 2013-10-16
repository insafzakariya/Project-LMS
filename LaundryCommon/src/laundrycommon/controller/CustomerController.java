package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.Customer;

/**
 *
 * @author insaf
 */
public interface CustomerController extends Remote{
    public boolean addCustomer(Customer customer) throws RemoteException, SQLException,ClassNotFoundException;
    public ArrayList<Customer> getAll() throws RemoteException, SQLException,ClassNotFoundException;
}
