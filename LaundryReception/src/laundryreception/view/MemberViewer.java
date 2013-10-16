package laundryreception.view;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundrycommon.ServerConnector;
import laundrycommon.controller.CustomerController;
import laundrycommon.model.Customer;
import laundrycommon.view.Viewer2;

/**
 *
 * @author Sentinel
 */
public class MemberViewer extends Viewer2{
    ServerConnector serverConnector;
    CustomerController customerController;
    ArrayList<Customer> dataList;
    
    MemberViewer(String title){
        super(title);
        
        try {
            viewerDTM.setColumnIdentifiers(new String[]{"Customer ID","Customer name","Telephone"});
            
            serverConnector = ServerConnector.getServerConnector();
            customerController = serverConnector.getCustomerController();
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MemberViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        populateTableFromDB();
    }
    
    @Override
    protected void populateTableFromDB() {
        try {
            dataList = customerController.getAll();
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MemberViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateTableFromList();
    }

    @Override
    public final void populateTableFromList() {
        for(Customer customer:dataList)
            viewerDTM.addRow(new String[]{customer.getCid(),customer.getName(),customer.getTelNo()});
    }
    
    public static void main(String[] args) {
        new MemberViewer("hot").setVisible(true);
    }

    @Override
    protected void initAddDialog() {
        addDialog = new AddMemberDialog(this, true);
    }
    
}
