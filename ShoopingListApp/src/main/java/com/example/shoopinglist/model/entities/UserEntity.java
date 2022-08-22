package com.example.shoopinglist.model.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {


    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<ProductEntity> products;

    public UserEntity() {
        super();
    }

    public List<ProductEntity> getProducts() {
        return products;
    }
    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
