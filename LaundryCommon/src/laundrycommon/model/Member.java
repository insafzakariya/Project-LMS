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
public class Member implements Serializable{
    private String cid;
    private String membership;

    public Member() {
    }

    public Member(String cid, String membership) {
        this.cid = cid;
        this.membership = membership;
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
     * @return the membership
     */
    public String getMembership() {
        return membership;
    }

    /**
     * @param membership the membership to set
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }
    
    
}
