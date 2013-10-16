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
public class MemberShipType implements Serializable{
    private String mt;
    private String type;
    private Double discount;

    public MemberShipType() {
    }

    public MemberShipType(String mt, String type,double discount) {
        this.mt = mt;
        this.type = type;
        this.discount=discount;
    }
    
    

    /**
     * @return the mt
     */
    public String getMt() {
        return mt;
    }

    /**
     * @param mt the mt to set
     */
    public void setMt(String mt) {
        this.mt = mt;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    
    
}
