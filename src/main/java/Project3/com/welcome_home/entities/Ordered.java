package Project3.com.welcome_home.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ordered")
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID", nullable = false)
    private Integer orderID;

    @Column(name = "orderDate", nullable = false)
    private java.sql.Date orderDate;

    @Column(name = "orderNotes")
    private String orderNotes;

    @ManyToOne
    @JoinColumn(name = "supervisor", referencedColumnName = "userName", nullable = false)
    private Person supervisor;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "userName", nullable = false)
    private Person client;

    // Getters and Setters
    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNotes() {
        return orderNotes;
    }

    public void setOrderNotes(String orderNotes) {
        this.orderNotes = orderNotes;
    }

    public Person getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Person supervisor) {
        this.supervisor = supervisor;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }
}
