package laundryserver.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import laundrycommon.controller.MembershipController;
import laundrycommon.model.MembershipType;
import laundryserver.dbaccess.MembershipTypeDBAccess;

/**
 *
 * @author Sentinel
 */
public class MemberShipControllerImpl extends UnicastRemoteObject implements MembershipController {

    private MembershipTypeDBAccess memberShipTypeDBAccess = new MembershipTypeDBAccess();

    MemberShipControllerImpl() throws RemoteException {
    }

    @Override
    public boolean setMemberShipType(MembershipType memberShipType) throws RemoteException, SQLException, ClassNotFoundException {
        System.out.println("1st");
        return memberShipTypeDBAccess.setMemberShipType(memberShipType);
    }

    @Override
    public ArrayList<MembershipType> getMemberShipTypes() throws RemoteException, SQLException, ClassNotFoundException {
        System.out.println("test");
        ArrayList<MembershipType> memberShipTypes = new ArrayList<>();
        ResultSet resultSet = memberShipTypeDBAccess.getMemberShipTypes();
        while (resultSet.next()) {
            MembershipType memberShipType = new MembershipType();
            memberShipType.setMt(resultSet.getString("mt"));
            memberShipType.setType(resultSet.getString("type"));
            memberShipType.setDiscount(resultSet.getFloat("discount"));
            memberShipTypes.add(memberShipType);

        }
        return memberShipTypes;
    }

    @Override
    public boolean removeMemberShipType(String mt) throws RemoteException, SQLException, ClassNotFoundException {
        return  memberShipTypeDBAccess.removeMemberShipType(mt);
    }
}
