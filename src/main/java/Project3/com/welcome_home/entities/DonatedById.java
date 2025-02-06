package Project3.com.welcome_home.entities;

import java.io.Serializable;
import java.util.Objects;

public class DonatedById implements Serializable {

    private Integer itemID;
    private String userName;

    // Default constructor
    public DonatedById() {}

    // Constructor
    public DonatedById(Integer itemID, String userName) {
        this.itemID = itemID;
        this.userName = userName;
    }

    // Getters and Setters
    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DonatedById that = (DonatedById) o;
        return Objects.equals(itemID, that.itemID) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, userName);
    }
}
