package laundrycommon.model;

import java.io.Serializable;

/**
 *
 * @author Sentinel
 */
public class Service implements Serializable{

    private int id;
    private String name;

    public Service(int id, String name) {
        this.id=id;
        this.name=name;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

}
