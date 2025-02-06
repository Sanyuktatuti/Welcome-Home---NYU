package Project3.com.welcome_home.entities;

import java.io.Serializable;
import java.util.Objects;

public class ItemInId implements Serializable {

    private Integer ItemId;
    private Integer orderID;

    // Default constructor
    public ItemInId() {}

    // Constructor
    public ItemInId(Integer ItemId, Integer orderID) {
        this.ItemId = ItemId;
        this.orderID = orderID;
    }

    // Getters and Setters
    public Integer getItemID() {
        return ItemId;
    }

    public void setItemID(Integer itemID) {
        this.ItemId = itemID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInId itemInId = (ItemInId) o;
        return Objects.equals(ItemId, itemInId.ItemId) &&
                Objects.equals(orderID, itemInId.orderID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ItemId, orderID);
    }
}
