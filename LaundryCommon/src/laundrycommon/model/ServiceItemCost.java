package laundrycommon.model;

import java.io.Serializable;

/**
 *
 * @author Sentinel
 */
public class ServiceItemCost implements Serializable{

    private int sid;
    int iid;
    private float cost;

    public ServiceItemCost() {   }

    public ServiceItemCost(int sid, int iid, float cost) {
        this.sid = sid;
        this.iid = iid;
        this.cost = cost;
    }

    /**
     * Get the value of iid
     *
     * @return the value of iid
     */
    public int getIid() {
        return iid;
    }

    /**
     * Set the value of iid
     *
     * @param iid new value of iid
     */
    public void setIid(int iid) {
        this.iid = iid;
    }

    /**
     * Get the value of cost
     *
     * @return the value of cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * Set the value of cost
     *
     * @param cost new value of cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * Get the value of sid
     *
     * @return the value of sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * Set the value of sid
     *
     * @param sid new value of sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }
}
