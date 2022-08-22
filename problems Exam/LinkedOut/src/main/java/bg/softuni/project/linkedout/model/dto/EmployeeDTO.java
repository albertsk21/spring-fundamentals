package bg.softuni.project.linkedout.model.dto;

import bg.softuni.project.linkedout.model.enums.EducationLevel;
import bg.softuni.project.linkedout.model.validation.annotations.DoubleGreaterThanZero;
import bg.softuni.project.linkedout.model.validation.annotations.NotMinorPerson;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EmployeeDTO {


    private String id;
    @NotMinorPerson(message = "Age must be older than 18 years")
    @DateTimeFormat( iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    @NotNull(message = "Education level cannot be empty")
    private EducationLevel educationLevel;
    @NotEmpty(message = "")
    @Size(min = 2, message = "First name must be more than 2")
    private String firstName;
    @NotEmpty(message = "")
    @Size(min = 2, message = "Last name must be more than 2")
    private String lastName;
    @NotEmpty(message = "Job title cannot be empty")
    private String jobTitle;
    @DoubleGreaterThanZero(message = "Salary must be higher than 0")
    private double salary;
    @NotEmpty(message = "Company name cannot be empty")
    private String companyName;

    public EmployeeDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public String getCompanyName() {
        return companyName;
    }
}
