/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryserver.reserve;

import java.util.HashMap;
import java.util.Map;
import laundrycommon.controller.ItemController;

/**
 *
 * @author insaf
 */
public class ItemReservation {

    private Map<String, ItemController> itemMap;

    public ItemReservation() {
        itemMap = new HashMap<String, ItemController>();
    }

    public boolean reserveItem(String id, ItemController itemController) {
        if (itemMap.containsKey(id)) {
            if (itemMap.get(id) == itemController) {
                return true;
            } else {
                return false;
            }
        } else {
            itemMap.put(id, itemController);
            return true;

        }
    }

    public boolean releaseItem(String id, ItemController itemController) {
        if (itemMap.containsKey(id)) {
            if (itemMap.get(id).equals(itemController)) {
                itemMap.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
