package Project3.com.welcome_home.entities;

import jakarta.persistence.*;

@Entity
@IdClass(PersonPhoneId.class)
public class PersonPhone {

    @Id
    private String userName;

    @Id
    private String phone;

    private String someOtherField; // Example field

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

    public String getSomeOtherField() {
        return someOtherField;
    }

    public void setSomeOtherField(String someOtherField) {
        this.someOtherField = someOtherField;
    }
}
