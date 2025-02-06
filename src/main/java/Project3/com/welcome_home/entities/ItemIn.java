package Project3.com.welcome_home.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ItemInId.class)
public class ItemIn implements Serializable {

    @Id
    private Integer ItemId;

    @Id
    private Integer orderID;

    @ManyToOne
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "orderID", insertable = false, updatable = false)
    private Ordered ordered;

    private Boolean found;

    // Default constructor
    public ItemIn() {}

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

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }
}
