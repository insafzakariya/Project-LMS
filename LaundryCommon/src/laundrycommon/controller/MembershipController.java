/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundrycommon.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.model.MemberShipType;

/**
 *
 * @author insaf
 */
public interface MembershipController  extends Remote{
    public boolean setMemberShipType(MemberShipType memberShipType)throws RemoteException, SQLException,ClassNotFoundException;
    public ArrayList<MemberShipType> getMemberShipTypes()throws RemoteException,SQLException,ClassNotFoundException;
    public boolean removeMemberShipType(String mt) throws RemoteException,SQLException,ClassNotFoundException;
}
