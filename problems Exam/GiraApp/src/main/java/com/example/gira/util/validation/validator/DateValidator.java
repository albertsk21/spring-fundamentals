package com.example.gira.util.validation.validator;

import com.example.gira.util.validation.annotations.NotInThePast;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateValidator implements ConstraintValidator<NotInThePast, Date> {
    @Override
    public void initialize(NotInThePast constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {

        if (value == null){
            return false;
        }

        LocalDate currentDate = this.convertToLocalDate(value);
        if(currentDate.equals(LocalDate.now())){
            return true;
        }

        return LocalDate.now().isBefore(currentDate);
    }
    private LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }
}
