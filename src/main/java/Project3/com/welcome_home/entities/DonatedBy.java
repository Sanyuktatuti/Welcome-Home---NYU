package Project3.com.welcome_home.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(DonatedById.class)
public class DonatedBy implements Serializable {

    @Id
    private Integer itemID;

    @Id
    private String userName;

    @ManyToOne
    @JoinColumn(name = "itemID", insertable = false, updatable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "userName", insertable = false, updatable = false)
    private Person person;

    @Temporal(TemporalType.DATE)
    private Date donateDate;

    // Default constructor
    public DonatedBy() {}

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

    public Date getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(Date donateDate) {
        this.donateDate = donateDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
