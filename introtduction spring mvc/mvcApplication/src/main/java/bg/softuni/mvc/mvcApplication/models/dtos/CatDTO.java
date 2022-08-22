package bg.softuni.mvc.mvcApplication.models.dtos;

public class CatDTO {


    private Long id;
    private String name;
    private int age;


    public CatDTO() {
    }

    public Long getId() {
        return id;
    }

    public CatDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CatDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public CatDTO setAge(int age) {
        this.age = age;
        return this;
    }
}
