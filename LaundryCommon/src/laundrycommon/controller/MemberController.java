package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import laundrycommon.model.Member;

/**
 *
 * @author Spectore
 */
public interface MemberController extends Remote{
    public boolean addMember(Member member)throws RemoteException, SQLException,ClassNotFoundException;
    
}
