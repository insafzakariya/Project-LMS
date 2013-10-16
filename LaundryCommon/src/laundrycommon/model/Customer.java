/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laundrycommon.model;

import java.io.Serializable;

/**
 *
 * @author insaf
 */
public class Customer implements Serializable, Model{
    private String cid;
    private String name;
    private String telNo;

    public Customer() {
    }

    public Customer(String cid, String name, String telNo) {
        this.cid = cid;
        this.name = name;
        this.telNo = telNo;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    
    
}
