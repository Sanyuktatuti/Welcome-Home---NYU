package Project3.com.welcome_home.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    private String userName;
    private String password;
    private String fname;
    private String lname;
    private String email;

    // Many-to-many relationship with roles
    @OneToMany(mappedBy = "person")
    private Set<Act> roles;  // The roles associated with the person

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Act> getRoles() {
        return roles;
    }

    public void setRoles(Set<Act> roles) {
        this.roles = roles;
    }

    // Optional: Add a method to get the roleID directly if needed
    public String getRoleID() {
        return roles != null && !roles.isEmpty() ? roles.iterator().next().getRole().getRoleID() : null;
    }
}
