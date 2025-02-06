package Project3.com.welcome_home.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;

@Entity
public class Delivered {

    @EmbeddedId
    private DeliveredId deliveredId;

    private String status;
    private String date;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Ordered ordered;

    public Delivered() {}

    public Delivered(DeliveredId deliveredId, String status, String date) {
        this.deliveredId = deliveredId;
        this.status = status;
        this.date = date;
    }

    // Getters and Setters
    public DeliveredId getDeliveredId() {
        return deliveredId;
    }

    public void setDeliveredId(DeliveredId deliveredId) {
        this.deliveredId = deliveredId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
