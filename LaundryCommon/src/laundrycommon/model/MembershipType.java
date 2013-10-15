package laundrycommon.model;

import java.io.Serializable;

/**
 *
 * @author insaf
 */
public class MembershipType implements Serializable{
    private String mt;
    private String type;
    private float discount;

    public MembershipType() {
    }

    public MembershipType(String mt, String type, float discount) {
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
    public float getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    
}
