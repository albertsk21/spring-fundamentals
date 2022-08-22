package bg.softuni.userproject.model.dtos;

import bg.softuni.userproject.model.enums.UserTypeEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraintvalidation.SupportedValidationTarget;

public class UserDTO {

    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

    private UserTypeEnum userType;

    public UserDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }


    public Long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public UserTypeEnum getUserType() {
        return userType;
    }
}
