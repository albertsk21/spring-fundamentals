package bg.softuni.mvc.mvcApplication.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class CatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public CatEntity() {
    }

    public Long getId() {
        return id;
    }

    public CatEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CatEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public CatEntity setAge(int age) {
        this.age = age;
        return this;
    }
}
