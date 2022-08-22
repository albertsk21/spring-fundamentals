package bg.softuni.project.linkedout.model.validation.validators;


import bg.softuni.project.linkedout.model.validation.annotations.NotMinorPerson;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthdateValidator implements ConstraintValidator< NotMinorPerson,LocalDate> {
    @Override
    public void initialize(NotMinorPerson constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        if (value == null){
            return false;
        }

        LocalDate now = LocalDate.now();
        int diff = now.getYear() - value.getYear();
        return diff >= 18;
    }
}
