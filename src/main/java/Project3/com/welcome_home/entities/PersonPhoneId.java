package Project3.com.welcome_home.entities;

import java.io.Serializable;
import java.util.Objects;

public class PersonPhoneId implements Serializable {

    private String userName;
    private String phone;

    // Default constructor
    public PersonPhoneId() {
    }

    // Parameterized constructor
    public PersonPhoneId(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonPhoneId that = (PersonPhoneId) o;
        return Objects.equals(userName, that.userName) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, phone);
    }
}
