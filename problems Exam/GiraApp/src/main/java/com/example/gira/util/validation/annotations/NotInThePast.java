package com.example.gira.util.validation.annotations;

import com.example.gira.util.validation.validator.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DateValidator.class)
public @interface NotInThePast {

    String message() default "Invalid Date";

    Class <?> [] groups() default {};

    Class <? extends Payload> [] payload() default {};

}
