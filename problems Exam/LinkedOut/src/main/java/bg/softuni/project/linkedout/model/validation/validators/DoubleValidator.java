package bg.softuni.project.linkedout.model.validation.validators;

import bg.softuni.project.linkedout.model.validation.annotations.DoubleGreaterThanZero;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleValidator implements ConstraintValidator<DoubleGreaterThanZero,Double> {

    @Override
    public void initialize(DoubleGreaterThanZero constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value > 0;
    }
}
