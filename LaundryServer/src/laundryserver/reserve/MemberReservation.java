package laundryserver.reserve;

import java.util.HashMap;
import java.util.Map;
import laundrycommon.controller.MemberController;

/**
 *
 * @author Sentinel
 */
public class MemberReservation {

    private Map<String, MemberController> memberMap;
    
    public MemberReservation() {
        memberMap = new HashMap<String, MemberController>();
    }

    public boolean recerveMember(String id, MemberController memberController) {
        if (memberMap.containsKey(id)) {
            if (memberMap.get(id) == memberController) {
                return true;
            } else {
                return false;
            }
        } else {
            memberMap.put(id, memberController);
            return true;
        }
    }
    
    public boolean releaseMember(String id, MemberController memberController) {
        if (memberMap.containsKey(id)) {
            if (memberMap.get(id).equals(memberController)) {
                memberMap.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }        
    }
}
