package com.example.spotifyplaylistapp.util.validator;

import com.example.spotifyplaylistapp.util.annotations.NotInTheFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateValidator implements ConstraintValidator<NotInTheFuture, Date> {
    @Override
    public void initialize(NotInTheFuture constraintAnnotation) {
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

        return LocalDate.now().isAfter(currentDate);
    }
    private LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }
}
