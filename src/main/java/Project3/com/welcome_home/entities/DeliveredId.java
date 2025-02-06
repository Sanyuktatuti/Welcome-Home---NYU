package Project3.com.welcome_home.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DeliveredId implements Serializable {

    private String userName;
    private int orderID;

    public DeliveredId() {}

    public DeliveredId(String userName, int orderID) {
        this.userName = userName;
        this.orderID = orderID;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveredId that = (DeliveredId) o;
        return orderID == that.orderID && userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return 31 * userName.hashCode() + orderID;
    }
}
