package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import laundrycommon.controller.MemberController;
import laundrycommon.model.Member;
import laundryserver.dbaccess.MemberDBAccess;

/**
 *
 * @author Sentinel
 */
public class MemberControllerImpl extends UnicastRemoteObject implements MemberController{
    private static MemberDBAccess memberDBAccess=new MemberDBAccess();
    
    MemberControllerImpl() throws RemoteException{
        
    }

    @Override
    public boolean addMember(Member member) throws RemoteException, SQLException, ClassNotFoundException {
        return memberDBAccess.addMember(member);
    }
    
}
