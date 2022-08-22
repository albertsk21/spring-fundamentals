package bg.softuni.userproject.model.entities;

import bg.softuni.userproject.model.enums.UserTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private UserTypeEnum userType;
    public UserEntity() {
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
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "firts_name")
    public String getFirstName() {
        return firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    public UserTypeEnum getUserType() {
        return userType;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

}
