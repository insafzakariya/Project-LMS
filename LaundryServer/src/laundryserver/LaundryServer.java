package laundryserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundryserver.impl.RemoteFactoryImpl;

/**
 *
 * @author Spectore
 */
public class LaundryServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry laundryServerReg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            laundryServerReg.rebind("LaundryFactory", new RemoteFactoryImpl());
        } catch (RemoteException ex) {
            Logger.getLogger(LaundryServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
