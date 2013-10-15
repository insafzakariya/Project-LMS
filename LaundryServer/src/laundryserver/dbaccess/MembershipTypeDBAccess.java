package laundryserver.dbaccess;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import laundrycommon.model.MembershipType;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author insaf
 */
public class MembershipTypeDBAccess {

    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean setMemberShipType(MembershipType memberShipType) throws RemoteException, SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            System.out.println("2nd");
            Connection connection = DBConnection.getConnectionTo();
            String sql = "INSERT INTO membership(mid,type,discount) VALUES(?,?,?)";
            Object data[] = {memberShipType.getMt(), memberShipType.getType(),memberShipType.getDiscount()};
            System.out.println("3rd");
            int res = DBHandel.setData(connection, sql, data);
            
            System.out.println("sdvjgs" + res);
            if (res > 0) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ResultSet getMemberShipTypes() throws RemoteException, SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getConnectionTo();
        String sql = "SELECT * FROM membership_type";
        ResultSet resultSet = DBHandel.getData(connection, sql);

        return resultSet;
    }
    public boolean removeMemberShipType(String mt) throws RemoteException, SQLException, ClassNotFoundException {
       boolean check=false;
        Connection connection=DBConnection.getConnectionTo();
        String sql="DELETE FROM membership_type where mt='"+mt+"'";
        int res=DBHandel.setSingleData(connection, sql);
        if(res>0){
            check=true;
        }
        return  check;
    }
}
