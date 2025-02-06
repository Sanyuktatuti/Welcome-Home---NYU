package Project3.com.welcome_home.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ActId.class)
public class Act implements Serializable {

    @Id
    private String userName;

    @Id
    private String roleID;

    @ManyToOne
    @JoinColumn(name = "userName", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "roleID", insertable = false, updatable = false)
    private Role role;

    // Default constructor
    public Act() {}

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
