package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import laundrycommon.controller.MemberController;
import laundrycommon.model.Member;

/**
 *
 * @author Spectore
 */
public class MemberControllerImpl extends UnicastRemoteObject implements MemberController{
    MemberControllerImpl() throws RemoteException{
        
    }

    @Override
    public boolean addMember(Member member) throws RemoteException, SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
