package bg.softuni.project.linkedout.model.entities;

import bg.softuni.project.linkedout.model.enums.EducationLevel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity{

    private LocalDate birthdate;
    private EducationLevel educationLevel;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private double salary;
    private CompanyEntity company;


    @Column(nullable = false)
    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "job_title", nullable = false)
    public String getJobTitle() {
        return jobTitle;
    }

    @Column(nullable = false)
    public double getSalary() {
        return salary;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
