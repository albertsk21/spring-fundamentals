package com.market.supermarket.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sellers")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;
    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private double salary;
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopEntity shop;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private SellerEntity manager;
    @OneToMany(mappedBy = "manager")
    private List<SellerEntity> sellers;

    public SellerEntity() {
    }


    public SellerEntity getManager() {
        return manager;
    }

    public SellerEntity setManager(SellerEntity manager) {
        this.manager = manager;
        return this;
    }

    public List<SellerEntity> getSellers() {
        return sellers;
    }

    public SellerEntity setSellers(List<SellerEntity> sellers) {
        this.sellers = sellers;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SellerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public SellerEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SellerEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public SellerEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public SellerEntity setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public SellerEntity setShop(ShopEntity shop) {
        this.shop = shop;
        return this;
    }
}
