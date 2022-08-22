package com.example.shoopinglist.util.validation.validator;


import com.example.shoopinglist.util.validation.annotations.IsNotInThePast;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
public class DateValidator implements ConstraintValidator<IsNotInThePast, LocalDateTime> {

    @Override
    public void initialize(IsNotInThePast constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if (value == null){
            return true;
        }
        LocalDateTime present = LocalDateTime.now();
       return value.isAfter(present);

    }
}