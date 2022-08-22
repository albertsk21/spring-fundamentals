package com.example.battleships.util.validation.validator;

import com.example.battleships.util.validation.annotations.IsNotInTheFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<IsNotInTheFuture, LocalDate> {
    @Override
    public void initialize(IsNotInTheFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {

        int presentYear = LocalDate.now().getYear();
        int presentMonth = LocalDate.now().getMonthValue();
        int presentDay = LocalDate.now().getDayOfMonth();

        int yearValue = value.getYear();
        int monthValue = value.getMonthValue();
        int dayValue = value.getDayOfMonth();

        if(presentYear > yearValue) return true;
        if(presentMonth < monthValue) return false;

        return presentDay >= dayValue;
    }
}
