package bg.softuni.project.linkedout.model.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

     private double budget;
     private String description;
     private String name;
     private String town;
     private Set<EmployeeEntity> employees;

    @Column(nullable = false)
    public double getBudget() {
        return budget;
    }

    @Column(columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public String getTown() {
        return town;
    }

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTown(String town) {
        this.town = town;
    }
}
