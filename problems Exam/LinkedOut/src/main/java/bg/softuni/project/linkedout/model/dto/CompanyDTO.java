package bg.softuni.project.linkedout.model.dto;

import bg.softuni.project.linkedout.model.validation.annotations.DoubleGreaterThanZero;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CompanyDTO {


    private String id;

    @DoubleGreaterThanZero
    private double budget;

    @NotEmpty(message = "")
    @Size(min = 10, message = "Description must be more than 10")
    private String description;

    @NotEmpty(message = "")
    @Size(min = 2,max = 10, message = "Name length must be between 2 and 10")
    private String name;

    @NotEmpty(message = "")
    @Size(min = 2,max = 10, message = "Town length must be between 2 and 10")
    private String town;

    public CompanyDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
