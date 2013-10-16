/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.dbaccess;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import laundrycommon.model.Member;
import laundryserver.db.DBConnection;
import laundryserver.db.DBHandel;

/**
 *
 * @author insaf
 */
public class MemberDBAccess {
     public boolean addMember(Member member) throws RemoteException, SQLException, ClassNotFoundException {
         boolean check=false;
         Connection connection= DBConnection.getConnectionTo();
         String sql="INSERT INTO member(cid,membership) "+"VALUES(?,?)";
         Object[]data={member.getCid(),member.getMembership()};
         int res=DBHandel.setData(connection, sql, data);
         if(res>0){
             check=true;
         }
         return check;
    }
    
    
}
