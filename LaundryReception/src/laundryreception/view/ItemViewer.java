/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryreception.view;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundrycommon.ServerConnector;
import laundrycommon.controller.ItemController;
import laundrycommon.model.Item;
import laundrycommon.view.Viewer2;

/**
 *
 * @author Spectore
 */
public class ItemViewer extends Viewer2 {

    ServerConnector serverConnector;
    ItemController itemController;
    ArrayList<Item> dataList;

    ItemViewer(String title) {
        super(title);
        try {
            viewerDTM.setColumnIdentifiers(new String[]{"Item ID", "Name", "Category"});

            serverConnector = ServerConnector.getServerConnector();
            itemController = serverConnector.getItemController();

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MemberViewer.class.getName()).log(Level.SEVERE, null, ex);
        }

        populateTableFromDB();
    }

    @Override
    protected void initAddDialog() {
        addDialog = new AddItemDialog(this, true);
    }

    @Override
    protected final void populateTableFromDB() {
        try {
            dataList = itemController.getAll();
        } catch (RemoteException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MemberViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateTableFromList();
    }

    @Override
    protected void populateTableFromList() {
        for (Item item:dataList)
            viewerDTM.addRow(new String[]{item.getId(),item.getName(),item.getCategory()});
    }
    public static void main(String[] args) {
        new ItemViewer("Items").setVisible(true);
    }
}
