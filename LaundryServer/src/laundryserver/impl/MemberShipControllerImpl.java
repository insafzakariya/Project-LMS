/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import laundrycommon.controller.MembershipController;
import laundrycommon.model.MemberShipType;
import laundryserver.dbaccess.MemberShipTypeDBAccess;

/**
 *
 * @author insaf
 */
public class MemberShipControllerImpl extends UnicastRemoteObject implements MembershipController {

    private MemberShipTypeDBAccess memberShipTypeDBAccess = new MemberShipTypeDBAccess();

    MemberShipControllerImpl() throws RemoteException {
    }

    @Override
    public boolean setMemberShipType(MemberShipType memberShipType) throws RemoteException, SQLException, ClassNotFoundException {
        System.out.println("1st");
        return memberShipTypeDBAccess.setMemberShipType(memberShipType);
    }

    @Override
    public ArrayList<MemberShipType> getMemberShipTypes() throws RemoteException, SQLException, ClassNotFoundException {
        System.out.println("test");
        ArrayList<MemberShipType> memberShipTypes = new ArrayList<>();
        ResultSet resultSet = memberShipTypeDBAccess.getMemberShipTypes();
        while (resultSet.next()) {
            MemberShipType memberShipType = new MemberShipType();
            memberShipType.setMt(resultSet.getString("mt"));
            memberShipType.setType(resultSet.getString("type"));
            memberShipType.setDiscount(resultSet.getDouble("discount"));
            memberShipTypes.add(memberShipType);

        }
        return memberShipTypes;
    }

    @Override
    public boolean removeMemberShipType(String mt) throws RemoteException, SQLException, ClassNotFoundException {
        return  memberShipTypeDBAccess.removeMemberShipType(mt);
    }
}
