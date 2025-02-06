package Project3.com.welcome_home.model;

import lombok.Data;

@Data
public class RegisterPersonDT {
    private String userName;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String role;
}
