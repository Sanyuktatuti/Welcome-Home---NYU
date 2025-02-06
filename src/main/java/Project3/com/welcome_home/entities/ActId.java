package Project3.com.welcome_home.entities;

import java.io.Serializable;
import java.util.Objects;

public class ActId implements Serializable {

    private String userName;
    private String roleID;

    // Default constructor
    public ActId() {}

    // Constructor
    public ActId(String userName, String roleID) {
        this.userName = userName;
        this.roleID = roleID;
    }

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

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActId actId = (ActId) o;
        return Objects.equals(userName, actId.userName) &&
                Objects.equals(roleID, actId.roleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, roleID);
    }
}
